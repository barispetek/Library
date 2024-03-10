package Kutuphane;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class mainKitap {
	
		public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        List<String> kitapAdlari = new ArrayList<>();
	        List<String> yazarlar = new ArrayList<>();
	        List<String> yayinevleri = new ArrayList<>();
	        List<Integer> sayfaSayilari = new ArrayList<>();
	        List<Integer> basimYillari = new ArrayList<>();
	        List<Double> fiyatlar = new ArrayList<>();
	        byte menu;

	        while (true) {
	            kitapFonksiyonlar.menuGoruntule();
	            menu = scanner.nextByte();

	            switch (menu) {
	                case 1:
	                    kitapFonksiyonlar.kitapEkle(kitapAdlari, yazarlar, yayinevleri, sayfaSayilari, basimYillari, fiyatlar, scanner);
	                    break;
	                case 2:
	                    kitapFonksiyonlar.kitapListele(kitapAdlari, yazarlar, yayinevleri, sayfaSayilari, basimYillari, fiyatlar);
	                    break;
	                case 3:
	                    System.out.println("Aranacak kitabın adını giriniz: ");
	                    String arananKitapAdi = scanner.next();
	                    kitapFonksiyonlar.kitapAra(kitapAdlari, yazarlar, yayinevleri, sayfaSayilari, basimYillari, fiyatlar, arananKitapAdi);
	                    break;
	                case 4:
	                    System.out.println("Düzeltilecek kitabın adını giriniz: ");
	                    String duzeltilecekKitapAdi = scanner.next();
	                    kitapFonksiyonlar.kitapDuzelt(kitapAdlari, yazarlar, yayinevleri, sayfaSayilari, basimYillari, fiyatlar, duzeltilecekKitapAdi, scanner);
	                    break;
	                case 5:
	                    System.out.println("Silinecek kitabın adını giriniz: ");
	                    String silinecekKitapAdi = scanner.next();
	                    kitapFonksiyonlar.kitapSil(kitapAdlari, yazarlar, yayinevleri, sayfaSayilari, basimYillari, fiyatlar, silinecekKitapAdi, scanner);
	                    break;
	                case 6:
	                    double ortalamaSayfa = kitapFonksiyonlar.ortalamaHesapla(sayfaSayilari);
	                    System.out.println("Kitap sayfa sayıları ortalaması: " + ortalamaSayfa);
	                    break;
	                case 7:
	                    kitapFonksiyonlar.enBuyukSayfaKitabiBul(kitapAdlari, yazarlar, sayfaSayilari, yayinevleri);
	                    break;
	                case 8:
	                    kitapFonksiyonlar.enKucukSayfaKitabiBul(kitapAdlari, yazarlar, sayfaSayilari, yayinevleri);
	                    break;
	                case 9:
	                    System.out.println("Programdan çıkılıyor...");
	                    System.exit(0);
	                    break;
	                default:
	                    System.out.println("Geçersiz menü değeri");
	                    break;
	            }
	        }
		}
	}
		
	


