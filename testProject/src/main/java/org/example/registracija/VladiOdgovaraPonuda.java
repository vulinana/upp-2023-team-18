package org.example.registracija;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class VladiOdgovaraPonuda {
    public static void main(String[] args) {


        String anonymous = "anonymous";
        String zaposleniUSektoruZaRegistraciju = "zaposleniUSektoruZaRegistraciju2";
        String sefSektoraZaRegistraciju = "siri";
        String sefVlade = "Vana";
        String noviKorisnikUsername = "noviKorisnik";
        String noviKorisnikPassword = "bpm";

        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:8080/bonita");
        driver.manage().window().maximize();
        driver.findElement(By.id("username")).sendKeys(anonymous);
        driver.findElement(By.id("password")).sendKeys("bpm");
        driver.findElement(By.cssSelector("input[type='submit']")).click();
        driver.get("http://localhost:8080/bonita/apps/userAppBonita/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Processes']"))).click();
        WebElement iframe =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("iframe")));
        driver.switchTo().frame(iframe);
        slowDown(1000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[text()='Registracija']"))).click();
        iframe =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("iframe")));
        driver.switchTo().frame(iframe);
        wait.until(ExpectedConditions.visibilityOfElementLocated((By.name("pbInput0")))).sendKeys("mojaUprava");
        WebElement dropDown = wait.until(ExpectedConditions.visibilityOfElementLocated((By.name("pbSelect0"))));
        dropDown.click();
        Select select = new Select(dropDown);
        slowDown(1000);
        select.selectByValue("0");
        wait.until(ExpectedConditions.visibilityOfElementLocated((By.name("pbInput1")))).sendKeys("Novi Sad");
        wait.until(ExpectedConditions.visibilityOfElementLocated((By.name("pbInput2")))).sendKeys("21000");
        wait.until(ExpectedConditions.visibilityOfElementLocated((By.name("pbInput3")))).sendKeys("21");
        //wait.until(ExpectedConditions.visibilityOfElementLocated((By.name("pbCheckbox0")))).click();
        slowDown(2000);
        driver.findElement(By.cssSelector("button[type='button']")).click();
        driver.switchTo().defaultContent();
        slowDown(2000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='anonymous']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Sign out']"))).click();

        //pravljenje personalizovane ponude
        slowDown(3000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username"))).sendKeys(zaposleniUSektoruZaRegistraciju);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password"))).sendKeys("bpm");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='submit']"))).click();
        slowDown(2000);
        driver.get("http://localhost:8080/bonita/apps/userAppBonita/");
        iframe =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("iframe")));
        driver.switchTo().frame(iframe);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[text()='Kreiranje personalizovane ponude']"))).click();
        iframe =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("iframe")));
        driver.switchTo().frame(iframe);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()=' Add StavkaPonude']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated((By.name("pbInput6")))).sendKeys("Kodifikacija zakona");
        wait.until(ExpectedConditions.visibilityOfElementLocated((By.name("pbInput7")))).sendKeys("1000");
        wait.until(ExpectedConditions.visibilityOfElementLocated((By.name("pbInput8")))).sendKeys("10000");
        slowDown(2000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Submit']"))).click();
        slowDown(2000);
        driver.switchTo().defaultContent();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Kristian Krizan']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Sign out']"))).click();

        //odobrenje sefa odeljenja
        slowDown(3000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username"))).sendKeys(sefSektoraZaRegistraciju);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password"))).sendKeys("bpm");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='submit']"))).click();
        driver.get("http://localhost:8080/bonita/apps/userAppBonita/");
        iframe =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("iframe")));
        driver.switchTo().frame(iframe);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[text()='Odobrenje sefa odeljenja']"))).click();
        iframe =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("iframe")));
        driver.switchTo().frame(iframe);
        slowDown(2000);
        driver.findElement(By.xpath("//button[text()='Odobri']")).click();
        slowDown(2000);
        driver.switchTo().defaultContent();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Dusan Janosevic']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Sign out']"))).click();

        //izbor stavki personalizovane ponude
        slowDown(3000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username"))).sendKeys(anonymous);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password"))).sendKeys("bpm");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='submit']"))).click();
        driver.get("http://localhost:8080/bonita/apps/userAppBonita/");
        iframe =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("iframe")));
        driver.switchTo().frame(iframe);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[text()='Izbor stavki personalizovane ponude']"))).click();
        iframe =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("iframe")));
        driver.switchTo().frame(iframe);
        wait.until(ExpectedConditions.visibilityOfElementLocated((By.name("pbCheckbox2")))).click();
        slowDown(2000);
        driver.findElement(By.xpath("//button[text()='Submit']")).click();
        slowDown(2000);
        driver.switchTo().defaultContent();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='anonymous']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Sign out']"))).click();

        //kreiranje ugovora
        slowDown(3000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username"))).sendKeys(zaposleniUSektoruZaRegistraciju);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password"))).sendKeys("bpm");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='submit']"))).click();
        driver.get("http://localhost:8080/bonita/apps/userAppBonita/");
        iframe =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("iframe")));
        driver.switchTo().frame(iframe);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[text()='Kreiranje ugovora']"))).click();
        iframe =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("iframe")));
        driver.switchTo().frame(iframe);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()=' Add StavkaUgovora']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated((By.name("pbInput10")))).sendKeys("Kodifikacija zakona");
        wait.until(ExpectedConditions.visibilityOfElementLocated((By.name("pbInput11")))).sendKeys("10000");
        slowDown(2000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Submit']"))).click();
        slowDown(2000);
        driver.switchTo().defaultContent();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Kristian Krizan']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Sign out']"))).click();

        //ostavi komentare na ugovor
        slowDown(3000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username"))).sendKeys(anonymous);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password"))).sendKeys("bpm");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='submit']"))).click();
        driver.get("http://localhost:8080/bonita/apps/userAppBonita/");
        iframe =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("iframe")));
        driver.switchTo().frame(iframe);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[text()='Pregled ugovora']"))).click();
        iframe =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("iframe")));
        driver.switchTo().frame(iframe);
        driver.findElement(By.xpath("//button[text()='Dodaj komentar']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated((By.name("pbInput3")))).sendKeys("skupo");
        slowDown(2000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Submit']"))).click();
        slowDown(2000);
        driver.switchTo().defaultContent();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='anonymous']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Sign out']"))).click();

        //ispravka ugovora
        slowDown(3000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username"))).sendKeys(zaposleniUSektoruZaRegistraciju);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password"))).sendKeys("bpm");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='submit']"))).click();
        driver.get("http://localhost:8080/bonita/apps/userAppBonita/");
        iframe =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("iframe")));
        driver.switchTo().frame(iframe);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[text()='Kreiranje ugovora']"))).click();
        iframe =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("iframe")));
        driver.switchTo().frame(iframe);
        WebElement cenaInput = wait.until(ExpectedConditions.visibilityOfElementLocated((By.name("pbInput8"))));
        cenaInput.clear();
        cenaInput.sendKeys("9000");
        slowDown(2000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Submit']"))).click();
        slowDown(2000);
        driver.switchTo().defaultContent();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Kristian Krizan']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Sign out']"))).click();

        //odobri ugovor
        slowDown(3000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username"))).sendKeys(anonymous);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password"))).sendKeys("bpm");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='submit']"))).click();
        driver.get("http://localhost:8080/bonita/apps/userAppBonita/");
        iframe =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("iframe")));
        driver.switchTo().frame(iframe);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[text()='Pregled ugovora']"))).click();
        iframe =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("iframe")));
        driver.switchTo().frame(iframe);
        wait.until(ExpectedConditions.visibilityOfElementLocated((By.name("pbCheckbox0")))).click();
        slowDown(2000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Submit']"))).click();
        slowDown(2000);
        driver.switchTo().defaultContent();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='anonymous']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Sign out']"))).click();
        //driver.close();

        //potpis agencije
        slowDown(3000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username"))).sendKeys(sefSektoraZaRegistraciju);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password"))).sendKeys("bpm");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='submit']"))).click();
        driver.get("http://localhost:8080/bonita/apps/userAppBonita/");
        iframe =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("iframe")));
        driver.switchTo().frame(iframe);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[text()='Potpis Agencije']"))).click();
        iframe =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("iframe")));
        driver.switchTo().frame(iframe);
        driver.findElement(By.name("pbUpload0")).sendKeys("C:/Users/smvul/OneDrive/Desktop/dummy.pdf");
        slowDown(2000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Submit']"))).click();
        slowDown(2000);
        driver.switchTo().defaultContent();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Dusan Janosevic']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Sign out']"))).click();

        //potpis vlade
        slowDown(3000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username"))).sendKeys(sefVlade);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password"))).sendKeys("bpm");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='submit']"))).click();
        driver.get("http://localhost:8080/bonita/apps/userAppBonita/");
        iframe =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("iframe")));
        driver.switchTo().frame(iframe);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[text()='Potpis Vlade']"))).click();
        iframe =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("iframe")));
        driver.switchTo().frame(iframe);
        driver.findElement(By.name("pbUpload0")).sendKeys("C:/Users/smvul/OneDrive/Desktop/dummy.pdf");
        slowDown(2000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Submit']"))).click();
        slowDown(2000);
        driver.switchTo().defaultContent();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Ana Vulin']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Sign out']"))).click();

        //placanje vlade
        slowDown(3000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username"))).sendKeys(anonymous);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password"))).sendKeys("bpm");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='submit']"))).click();
        driver.get("http://localhost:8080/bonita/apps/userAppBonita/");
        iframe =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("iframe")));
        driver.switchTo().frame(iframe);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[text()='Placanje ugovora']"))).click();
        iframe =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("iframe")));
        driver.switchTo().frame(iframe);
        driver.findElement(By.name("pbCheckbox0")).click();
        slowDown(2000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Submit']"))).click();
        slowDown(2000);
        driver.switchTo().defaultContent();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='anonymous']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Sign out']"))).click();

        //slanje kredencijala
        slowDown(3000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username"))).sendKeys(zaposleniUSektoruZaRegistraciju);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password"))).sendKeys("bpm");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='submit']"))).click();
        driver.get("http://localhost:8080/bonita/apps/userAppBonita/");
        iframe =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("iframe")));
        driver.switchTo().frame(iframe);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[text()='Slanje kredencijala']"))).click();
        iframe =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("iframe")));
        driver.switchTo().frame(iframe);
        driver.findElement(By.name("pbInput0")).sendKeys(noviKorisnikUsername);
        driver.findElement(By.name("pbInput1")).sendKeys(noviKorisnikPassword);
        slowDown(2000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Submit']"))).click();
        slowDown(2000);
        driver.switchTo().defaultContent();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Kristian Krizan']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Sign out']"))).click();

        //otpremanje zakona vlade
        slowDown(3000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username"))).sendKeys(noviKorisnikUsername);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password"))).sendKeys(noviKorisnikPassword);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='submit']"))).click();
        driver.get("http://localhost:8080/bonita/apps/userAppBonita/");
        iframe =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("iframe")));
        driver.switchTo().frame(iframe);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[text()='Otpremanje zakona vlade']"))).click();
        iframe =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("iframe")));
        driver.switchTo().frame(iframe);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()=' Add File']"))).click();
        driver.findElement(By.name("pbUpload0")).sendKeys("C:/Users/smvul/OneDrive/Desktop/dummy.pdf");
        slowDown(2000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Submit']"))).click();
        slowDown(2000);
        driver.switchTo().defaultContent();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='" + noviKorisnikUsername + "']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Sign out']"))).click();

        driver.close();
    }

    // Funkcija koja simulira usporavanje
    private static void slowDown(int time) {
        try {
            Thread.sleep(time); // Pauza od 2 sekunde između koraka
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}