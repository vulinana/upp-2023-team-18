package org.example.registracija;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class VladiNeOdgovaraPersonalizovanaPonuda {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:8080/bonita");
        driver.manage().window().maximize();
        driver.findElement(By.id("username")).sendKeys("anonymous");
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
        select.selectByValue("0");
        wait.until(ExpectedConditions.visibilityOfElementLocated((By.name("pbInput1")))).sendKeys("Novi Sad");
        wait.until(ExpectedConditions.visibilityOfElementLocated((By.name("pbInput2")))).sendKeys("21000");
        wait.until(ExpectedConditions.visibilityOfElementLocated((By.name("pbInput3")))).sendKeys("21");
        //wait.until(ExpectedConditions.visibilityOfElementLocated((By.name("pbCheckbox0")))).click();
        slowDown(2000);
        driver.findElement(By.cssSelector("button[type='button']")).click();
        slowDown(2000);
        driver.switchTo().defaultContent();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='anonymous']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Sign out']"))).click();

        //pravljenje personalizovane ponude
        slowDown(3000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username"))).sendKeys("zaposleniUSektoruZaRegistraciju2");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password"))).sendKeys("bpm");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='submit']"))).click();
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
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username"))).sendKeys("siri");
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

        slowDown(3000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username"))).sendKeys("anonymous");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password"))).sendKeys("bpm");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='submit']"))).click();
        driver.get("http://localhost:8080/bonita/apps/userAppBonita/");
        iframe =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("iframe")));
        driver.switchTo().frame(iframe);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[text()='Izbor stavki personalizovane ponude']"))).click();
        iframe =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("iframe")));
        driver.switchTo().frame(iframe);
        wait.until(ExpectedConditions.visibilityOfElementLocated((By.name("pbCheckbox1")))).click();
        slowDown(2000);
        driver.findElement(By.xpath("//button[text()='Submit']")).click();
        slowDown(2000);

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