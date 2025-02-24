package p16_09_2022;

import java.time.Duration;
import java.util.List;

import org.checkerframework.checker.units.qual.t;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.w3c.dom.html.HTMLTableSectionElement;

public class Zadatak2 {

	public static void main(String[] args) throws InterruptedException {
	/*
	 * Kreirati klasu HtmlTable:
koja od atributa ima table web element sa stranice
konstruktor koji prima web element sa kojim se radi

metodu getCellText, koja prima dva parametra row i cell od kog hocemo da procitamo tekst. 
Npr ako se za tabelu(2012 goald medal olympic drivers)  sa linka prozovmeo metodu sa row=1 i cell =3 metoda vraca vrednost  China
metodu getColumnsByName, metoda kao parametar prima naslov kolone a vraca niz elemenata, gde je svaki element celija iz trazene kolone. 
Npr ako se pozove metoda za “Country”, metoda vraca UnitedStates, China, China, ….Russia, …China samo ne stringove nego 
elemente koji cuvaju te vrednosti!
metodu sortDescending, koja kao parametar prima naziv kolone. Metoda treba da uradi potrebne akcije da se tabela sortira u 
opadajucem redosledu po trazenoj koloni. POMOC: Sortiranje je izvrseno ukoliko header trazene kolone ima klasu headerSortUp
metodu sortDescending, koja kao parametar prima naziv kolone. Metoda radi slicno kao za descending

U glavnom programu:
Ucitati stranicu https://www.bu.edu/tech/services/cccs/websites/www/wordpress/how-to/sortable-searchable-tables/
Kreirati HtmlTable objekat koji se veze za 2012 Gold Medal Olympic Divers tabelu sa stranice
Probajte metodu getCellText

	 */
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver1.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.bu.edu/tech/services/cccs/websites/www/wordpress/how-to/sortable-searchable-tables/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		HtmlTable tabela = new HtmlTable(driver.findElement(By.className("sortable")));
		System.out.println("US: " + tabela.getCellText(1, 3));
		
		List<WebElement> lista = tabela.getColumnsByName("Athlete");
		for (int i = 0; i < lista.size(); i++) {
			System.out.print(lista.get(i).getText() + ",");
		}
		System.out.println();
		
	
		tabela.sortAscending("Age");// ovo proveri
		
		
		Thread.sleep(5000);
		driver.quit();
		
		
	}

}
