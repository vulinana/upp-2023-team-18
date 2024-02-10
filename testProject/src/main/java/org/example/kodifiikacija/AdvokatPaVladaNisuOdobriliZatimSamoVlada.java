package org.example.kodifiikacija;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AdvokatPaVladaNisuOdobriliZatimSamoVlada {
    public static void main(String[] args) {


        String zaposleniUVladi = "zaposleniUVladi";
        String zaposleniUVladiName = "Veljko Vulin";
        String zaposleniUAgenciji = "goca";
        String zaposleniUAgencijiName = "Gordana Sinjeri";
        String advokatZaReviziju = "rob";
        String advokatZaRevizijuName = "Srdjan Stjepanovic";

        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:8080/bonita");
        driver.manage().window().maximize();
        driver.findElement(By.id("username")).sendKeys(zaposleniUVladi);
        driver.findElement(By.id("password")).sendKeys("bpm");
        driver.findElement(By.cssSelector("input[type='submit']")).click();
        driver.get("http://localhost:8080/bonita/apps/userAppBonita/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Processes']"))).click();
        WebElement iframe =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("iframe")));
        driver.switchTo().frame(iframe);
        slowDown(1000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[text()='KodifikacijaZakona']"))).click();
        iframe =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("iframe")));
        driver.switchTo().frame(iframe);
        //WebElement dropDown = wait.until(ExpectedConditions.visibilityOfElementLocated((By.name("pbSelect0"))));
        //dropDown.click();
        //Select select = new Select(dropDown);
        //select.selectByValue("0");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()=' Add StavkaZahtevaZaKodifikaciju']"))).click();
        WebElement uploadForm = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("form[target='upload-iframe-2']")));
        uploadForm.findElement(By.name("pbUpload0")).sendKeys("C:/Users/smvul/OneDrive/Desktop/dummy.pdf");
        uploadForm = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("form[target='upload-iframe-3']")));
        uploadForm.findElement(By.name("pbUpload1")).sendKeys("C:/Users/smvul/OneDrive/Desktop/dummy.pdf");
        uploadForm = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("form[target='upload-iframe-4']")));
        uploadForm.findElement(By.name("pbUpload2")).sendKeys("C:/Users/smvul/OneDrive/Desktop/dummy.pdf");
        slowDown(2000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Submit']"))).click();
        driver.switchTo().defaultContent();
        slowDown(2000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='" + zaposleniUVladiName +  "']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Sign out']"))).click();

        //pregled dokumenata i postavljanje pitanja
        slowDown(3000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username"))).sendKeys(zaposleniUAgenciji);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password"))).sendKeys("bpm");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='submit']"))).click();
        driver.get("http://localhost:8080/bonita/apps/userAppBonita/");
        iframe =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("iframe")));
        driver.switchTo().frame(iframe);
        driver.findElement(By.cssSelector("input[type='checkbox'][bo-selector='task']")).click();
        slowDown(2000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Take']"))).click();
        slowDown(2000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[text()='Pregled dokumenta i postavljanje pitanja']"))).click();
        iframe =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("iframe")));
        driver.switchTo().frame(iframe);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()=' Add Pitanje']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated((By.name("pbInput0")))).sendKeys("Potrebno pojasnjenje prvog zakona");
        wait.until(ExpectedConditions.visibilityOfElementLocated((By.name("pbCheckbox0")))).click();
        slowDown(2000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Submit']"))).click();
        slowDown(2000);
        driver.switchTo().defaultContent();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='" + zaposleniUAgencijiName + "']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Sign out']"))).click();

        //izmena i dopuna zakona
        slowDown(3000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username"))).sendKeys(zaposleniUVladi);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password"))).sendKeys("bpm");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='submit']"))).click();
        driver.get("http://localhost:8080/bonita/apps/userAppBonita/");
        iframe =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("iframe")));
        driver.switchTo().frame(iframe);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[text()='Izmena i dopuna zakona']"))).click();
        iframe =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("iframe")));
        driver.switchTo().frame(iframe);
        wait.until(ExpectedConditions.visibilityOfElementLocated((By.name("pbInput1")))).sendKeys("Sve je ok");
        slowDown(2000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Submit']"))).click();
        slowDown(2000);
        driver.switchTo().defaultContent();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='" + zaposleniUVladiName + "']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Sign out']"))).click();

        //ponovni pregled
        slowDown(3000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username"))).sendKeys(zaposleniUAgenciji);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password"))).sendKeys("bpm");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='submit']"))).click();
        driver.get("http://localhost:8080/bonita/apps/userAppBonita/");
        iframe =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("iframe")));
        driver.switchTo().frame(iframe);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[text()='Ponovni pregled dokumenta i postavljanje pitanja']"))).click();
        iframe =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("iframe")));
        driver.switchTo().frame(iframe);
        slowDown(2000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Submit']"))).click();
        slowDown(3000);
        driver.switchTo().defaultContent();
        driver.navigate().refresh();

        //slanje izmenjenih zakona
        iframe =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("iframe")));
        driver.switchTo().frame(iframe);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[text()='Slanje izmenjenih zakona']"))).click();
        iframe =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("iframe")));
        driver.switchTo().frame(iframe);
        uploadForm = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("form[target='upload-iframe-2']")));
        uploadForm.findElement(By.name("pbUpload0")).sendKeys("C:/Users/smvul/OneDrive/Desktop/dummy.pdf");
        uploadForm = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("form[target='upload-iframe-3']")));
        uploadForm.findElement(By.name("pbUpload1")).sendKeys("C:/Users/smvul/OneDrive/Desktop/dummy.pdf");
        uploadForm = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("form[target='upload-iframe-4']")));
        uploadForm.findElement(By.name("pbUpload2")).sendKeys("C:/Users/smvul/OneDrive/Desktop/dummy.pdf");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("pbCheckbox0"))).click();
        slowDown(2000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Submit']"))).click();
        slowDown(3000);
        driver.switchTo().defaultContent();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='" + zaposleniUAgencijiName + "']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Sign out']"))).click();

        //Revizija advokata za reviziju
        slowDown(3000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username"))).sendKeys(advokatZaReviziju);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password"))).sendKeys("bpm");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='submit']"))).click();
        driver.get("http://localhost:8080/bonita/apps/userAppBonita/");
        iframe =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("iframe")));
        driver.switchTo().frame(iframe);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[text()='Revizija advokata za reviziju']"))).click();
        iframe =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("iframe")));
        driver.switchTo().frame(iframe);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()=' Add Primedba']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated((By.name("pbInput0")))).sendKeys("Izmeniti prvi zakon");
        slowDown(2000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Submit']"))).click();
        slowDown(2000);
        driver.switchTo().defaultContent();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='" + advokatZaRevizijuName + "']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Sign out']"))).click();

        //odgovor primarnog advokata
        slowDown(3000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username"))).sendKeys(zaposleniUAgenciji);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password"))).sendKeys("bpm");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='submit']"))).click();
        driver.get("http://localhost:8080/bonita/apps/userAppBonita/");
        iframe =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("iframe")));
        driver.switchTo().frame(iframe);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[text()='Odgovor ili promena zakona primarnog advokata']"))).click();
        iframe =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("iframe")));
        driver.switchTo().frame(iframe);
        wait.until(ExpectedConditions.visibilityOfElementLocated((By.name("pbInput1")))).sendKeys("Ne");
        slowDown(2000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Submit']"))).click();
        slowDown(2000);
        driver.switchTo().defaultContent();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='" + zaposleniUAgencijiName + "']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Sign out']"))).click();

        //ponovna revizija advokata za reviziju
        slowDown(3000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username"))).sendKeys(advokatZaReviziju);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password"))).sendKeys("bpm");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='submit']"))).click();
        driver.get("http://localhost:8080/bonita/apps/userAppBonita/");
        iframe =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("iframe")));
        driver.switchTo().frame(iframe);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[text()='Revizija advokata za reviziju']"))).click();
        iframe =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("iframe")));
        driver.switchTo().frame(iframe);
        wait.until(ExpectedConditions.visibilityOfElementLocated((By.name("pbCheckbox0")))).click();
        slowDown(2000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Submit']"))).click();
        slowDown(2000);
        driver.switchTo().defaultContent();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='" + advokatZaRevizijuName + "']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Sign out']"))).click();

        //pregled od strane vlade
        slowDown(3000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username"))).sendKeys(zaposleniUVladi);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password"))).sendKeys("bpm");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='submit']"))).click();
        driver.get("http://localhost:8080/bonita/apps/userAppBonita/");
        iframe =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("iframe")));
        driver.switchTo().frame(iframe);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[text()='Pregled od strane vlade']"))).click();
        iframe =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("iframe")));
        driver.switchTo().frame(iframe);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Dodaj']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated((By.name("pbInput0")))).sendKeys("drugi zakon");
        slowDown(2000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Submit']"))).click();
        slowDown(2000);
        driver.switchTo().defaultContent();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='" + zaposleniUVladiName + "']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Sign out']"))).click();

        //otpremanje zakona po zatrazenim izmenama
        slowDown(3000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username"))).sendKeys(zaposleniUAgenciji);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password"))).sendKeys("bpm");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='submit']"))).click();
        driver.get("http://localhost:8080/bonita/apps/userAppBonita/");
        iframe =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("iframe")));
        driver.switchTo().frame(iframe);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[text()='Otpremanje zakona po zatrazenim izmenama']"))).click();
        iframe =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("iframe")));
        driver.switchTo().frame(iframe);
        uploadForm = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("form[target='upload-iframe-2']")));
        uploadForm.findElement(By.name("pbUpload0")).sendKeys("C:/Users/smvul/OneDrive/Desktop/dummy.pdf");
        uploadForm = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("form[target='upload-iframe-3']")));
        uploadForm.findElement(By.name("pbUpload1")).sendKeys("C:/Users/smvul/OneDrive/Desktop/dummy.pdf");
        uploadForm = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("form[target='upload-iframe-4']")));
        uploadForm.findElement(By.name("pbUpload2")).sendKeys("C:/Users/smvul/OneDrive/Desktop/dummy.pdf");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("pbCheckbox1"))).click();
        slowDown(2000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Submit']"))).click();
        slowDown(2000);
        driver.switchTo().defaultContent();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='" + zaposleniUAgencijiName + "']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Sign out']"))).click();

        //ponovna revizija od strane advokata za reviziju
        slowDown(3000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username"))).sendKeys(advokatZaReviziju);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password"))).sendKeys("bpm");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='submit']"))).click();
        driver.get("http://localhost:8080/bonita/apps/userAppBonita/");
        iframe =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("iframe")));
        driver.switchTo().frame(iframe);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[text()='Ponovna revizija zahteva za kodifikaciju od advokata']"))).click();
        iframe =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("iframe")));
        driver.switchTo().frame(iframe);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Dodaj']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated((By.name("pbInput0")))).sendKeys("drugi zakon");
        slowDown(2000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Submit']"))).click();
        slowDown(2000);
        driver.switchTo().defaultContent();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='" + advokatZaRevizijuName + "']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Sign out']"))).click();

        //ponovni pregled od strane vlade
        slowDown(3000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username"))).sendKeys(zaposleniUVladi);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password"))).sendKeys("bpm");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='submit']"))).click();
        driver.get("http://localhost:8080/bonita/apps/userAppBonita/");
        iframe =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("iframe")));
        driver.switchTo().frame(iframe);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[text()='Ponovni Pregled od strane vlade 2']"))).click();
        iframe =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("iframe")));
        driver.switchTo().frame(iframe);
        wait.until(ExpectedConditions.visibilityOfElementLocated((By.name("pbInput0")))).clear();
        wait.until(ExpectedConditions.visibilityOfElementLocated((By.name("pbInput0")))).sendKeys("drugi zakon");
        slowDown(2000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Submit']"))).click();
        slowDown(2000);
        driver.switchTo().defaultContent();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='" + zaposleniUVladiName + "']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Sign out']"))).click();

        //otpremanje zakona po zatrazenim izmenama
        slowDown(3000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username"))).sendKeys(zaposleniUAgenciji);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password"))).sendKeys("bpm");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='submit']"))).click();
        driver.get("http://localhost:8080/bonita/apps/userAppBonita/");
        iframe =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("iframe")));
        driver.switchTo().frame(iframe);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[text()='Otpremanje zakona po zatrazenim izmenama']"))).click();
        iframe =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("iframe")));
        driver.switchTo().frame(iframe);
        uploadForm = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("form[target='upload-iframe-2']")));
        uploadForm.findElement(By.name("pbUpload0")).sendKeys("C:/Users/smvul/OneDrive/Desktop/dummy.pdf");
        uploadForm = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("form[target='upload-iframe-3']")));
        uploadForm.findElement(By.name("pbUpload1")).sendKeys("C:/Users/smvul/OneDrive/Desktop/dummy.pdf");
        uploadForm = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("form[target='upload-iframe-4']")));
        uploadForm.findElement(By.name("pbUpload2")).sendKeys("C:/Users/smvul/OneDrive/Desktop/dummy.pdf");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("pbCheckbox0"))).click();
        slowDown(2000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Submit']"))).click();
        slowDown(2000);
        driver.switchTo().defaultContent();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='" + zaposleniUAgencijiName + "']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Sign out']"))).click();

        //ponovni pregled od strane vlade
        slowDown(3000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username"))).sendKeys(zaposleniUVladi);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password"))).sendKeys("bpm");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='submit']"))).click();
        driver.get("http://localhost:8080/bonita/apps/userAppBonita/");
        iframe =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("iframe")));
        driver.switchTo().frame(iframe);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[text()='Ponovni pregled od strane vlade']"))).click();
        iframe =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("iframe")));
        driver.switchTo().frame(iframe);
        wait.until(ExpectedConditions.visibilityOfElementLocated((By.name("pbCheckbox0")))).click();
        slowDown(2000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Submit']"))).click();
        slowDown(2000);
        driver.switchTo().defaultContent();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='" + zaposleniUVladiName + "']"))).click();
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