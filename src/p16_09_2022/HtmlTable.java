package p16_09_2022;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HtmlTable {

	private WebElement table;
	private int brojKolone;

	public HtmlTable(WebElement table) {
		super();
		this.table = table;
		this.brojKolone = 0;
	}
	
	public String getCellText(int row, int cell) {
		WebElement tableCell = table.findElement(By.xpath("//*[contains(@class, 'sortable')]/tbody/tr[" + row + "]/td[" + cell + "]"));
		return tableCell.getText();
	}
	
	public List<WebElement> getColumnsByName(String columnsName) {
		for (int j = 1; j < 5; j++) {
			if(table.findElement(By.xpath("//*[contains(@class, 'sortable')]/thead/tr/th["+ j +"]")).getText().equals(columnsName)) {
				return table.findElements(By.xpath("//*[contains(@class, 'sortable')]/tbody/tr/td[" + j + "]"));
			}
			
		}
		return null;	
	}
	
	private void sort(String name) {
		for (int j = 1; j < 5; j++) {
			if(table.findElement(By.xpath("//*[contains(@class, 'sortable')]/thead/tr/th["+ j +"]")).getText().equals(name)) {
				table.findElement(By.xpath("//*[contains(@class, 'sortable')]/thead/tr/th["+ j +"]")).click();
				this.brojKolone = j;
			}
		}
	}
	
	
	public void sortDescending(String columnsName) {
		this.sort(columnsName);
		
		if (table.findElement(By.xpath("//*[contains(@class, 'sortable')]//thead/tr/th[" + this.brojKolone + "]"))
				.getAttribute("class")
				.equals("header headerSortUp")) {
			System.out.println("Sortiranje je opadajuce!");
		} else {
			this.sort(columnsName);
			System.out.println("Opadajuce!");
		}
		
	}
	
	public void sortAscending(String columnsName) {
		this.sort(columnsName);
		
		if (table.findElement(By.xpath("//*[contains(@class, 'sortable')]//thead/tr/th[" + this.brojKolone + "]"))
				.getAttribute("class")
				.equals("header headerSortDown")) {
			System.out.println("Sortiranje je rastuce!");
		} else {
			this.sort(columnsName);
			System.out.println("Rastuce!");
		}
	}
	
	
	
}
