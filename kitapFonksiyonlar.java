package Kutuphane;

import java.util.List;
import java.util.Scanner;

public class kitapFonksiyonlar {

	public static void menuGoruntule() {
        System.out.println("1-Kayıt girişi");
        System.out.println("2-Listeleme");
        System.out.println("3-İsim ile arama");
        System.out.println("4-Düzeltme");
        System.out.println("5-Silme");
        System.out.println("6-Ortalama");
        System.out.println("7-En büyük sayfa sayısına sahip kitabın kime ait olduğu");
        System.out.println("8-En küçük sayfa sayısına sahip kitabın kime ait olduğu");
        System.out.println("9-Çıkış");
        System.out.print("Seçiminizi yapın: ");
    }

    public static void kitapEkle(List<String> kitapAdlari, List<String> yazarlar, List<String> yayinevleri,
                                  List<Integer> sayfaSayilari, List<Integer> basimYillari, List<Double> fiyatlar,
                                  Scanner scanner) {
        System.out.print("Kitap Adı: ");
        String kitapAdi = scanner.next();
        System.out.print("Yazar: ");
        String yazar = scanner.next();
        System.out.print("Yayınevi: ");
        String yayinevi = scanner.next();
        System.out.print("Sayfa Sayısı: ");
        int sayfaSayisi = scanner.nextInt();
        System.out.print("Basım Yılı: ");
        int basimYili = scanner.nextInt();
        System.out.print("Fiyat: ");
        double fiyat = scanner.nextDouble();

        kitapAdlari.add(kitapAdi);
        yazarlar.add(yazar);
        yayinevleri.add(yayinevi);
        sayfaSayilari.add(sayfaSayisi);
        basimYillari.add(basimYili);
        fiyatlar.add(fiyat);

        System.out.println("Kitap başarıyla eklendi.");
    }

    public static void kitapListele(List<String> kitapAdlari, List<String> yazarlar, List<String> yayinevleri,
                                     List<Integer> sayfaSayilari, List<Integer> basimYillari, List<Double> fiyatlar) {
        if (kitapAdlari.isEmpty()) {
            System.out.println("Listede hiç kitap bulunmamaktadır.");
        } else {
            for (int i = 0; i < kitapAdlari.size(); i++) {
                System.out.println("Kitap Adı: " + kitapAdlari.get(i));
                System.out.println("Yazar: " + yazarlar.get(i));
                System.out.println("Yayınevi: " + yayinevleri.get(i));
                System.out.println("Sayfa Sayısı: " + sayfaSayilari.get(i));
                System.out.println("Basım Yılı: " + basimYillari.get(i));
                System.out.println("Fiyat: " + fiyatlar.get(i));
                System.out.println("-----------------------");
            }
        }
    }

    public static void kitapAra(List<String> kitapAdlari, List<String> yazarlar, List<String> yayinevleri,
                                 List<Integer> sayfaSayilari, List<Integer> basimYillari, List<Double> fiyatlar,
                                 String arananKitapAdi) {
        boolean bulundu = false;
        for (int i = 0; i < kitapAdlari.size(); i++) {
            if (kitapAdlari.get(i).equalsIgnoreCase(arananKitapAdi)) {
                System.out.println("Kitap bulundu:");
                System.out.println("Yazar: " + yazarlar.get(i));
                System.out.println("Yayınevi: " + yayinevleri.get(i));
                System.out.println("Sayfa Sayısı: " + sayfaSayilari.get(i));
                System.out.println("Basım Yılı: " + basimYillari.get(i));
                System.out.println("Fiyat: " + fiyatlar.get(i));
                bulundu = true;
                break;
            }
        }

        if (!bulundu) {
            System.out.println("Kitap bulunamadı.");
        }
    }

    public static void kitapDuzelt(List<String> kitapAdlari, List<String> yazarlar, List<String> yayinevleri,
                                    List<Integer> sayfaSayilari, List<Integer> basimYillari, List<Double> fiyatlar,
                                    String duzeltilecekKitapAdi, Scanner scanner) {
        boolean bulundu = false;
        for (int i = 0; i < kitapAdlari.size(); i++) {
            if (kitapAdlari.get(i).equalsIgnoreCase(duzeltilecekKitapAdi)) {
                System.out.println("Yeni bilgileri girin:");

                System.out.print("Kitap Adı: ");
                kitapAdlari.set(i, scanner.next());
                System.out.print("Yazar: ");
                yazarlar.set(i, scanner.next());
                System.out.print("Yayınevi: ");
                yayinevleri.set(i, scanner.next());
                System.out.print("Sayfa Sayısı: ");
                sayfaSayilari.set(i, scanner.nextInt());
                System.out.print("Basım Yılı: ");
                basimYillari.set(i, scanner.nextInt());
                System.out.print("Fiyat: ");
                fiyatlar.set(i, scanner.nextDouble());

                System.out.println("Kitap başarıyla düzeltildi.");
                bulundu = true;
                break;
            }
        }

        if (!bulundu) {
            System.out.println("Kitap bulunamadı.");
        }
    }

    public static void kitapSil(List<String> kitapAdlari, List<String> yazarlar, List<String> yayinevleri,
                                 List<Integer> sayfaSayilari, List<Integer> basimYillari, List<Double> fiyatlar,
                                 String silinecekKitapAdi, Scanner scanner) {
        boolean bulundu = false;
        for (int i = 0; i < kitapAdlari.size(); i++) {
            if (kitapAdlari.get(i).equalsIgnoreCase(silinecekKitapAdi)) {
                kitapAdlari.remove(i);
                yazarlar.remove(i);
                yayinevleri.remove(i);
                sayfaSayilari.remove(i);
                basimYillari.remove(i);
                fiyatlar.remove(i);

                System.out.println("Kitap başarıyla silindi.");
                bulundu = true;
                break;
            }
        }

        if (!bulundu) {
            System.out.println("Kitap bulunamadı.");
        }
    }

    public static double ortalamaHesapla(List<Integer> sayfaSayilari) {
        if (sayfaSayilari.isEmpty()) {
            return 0;
        } else {
            double toplamSayfa = 0;
            for (int sayfaSayisi : sayfaSayilari) {
                toplamSayfa += sayfaSayisi;
            }
            return toplamSayfa / sayfaSayilari.size();
        }
    }

    public static void enBuyukSayfaKitabiBul(List<String> kitapAdlari, List<String> yazarlar, List<Integer> sayfaSayilari, List<String> yayinevleri) {
        if (sayfaSayilari.isEmpty()) {
            System.out.println("Listede hiç kitap bulunmamaktadır.");
        } else {
            int maxSayfa = Integer.MIN_VALUE;
            int maxIndex = -1;

            for (int i = 0; i < sayfaSayilari.size(); i++) {
                if (sayfaSayilari.get(i) > maxSayfa) {
                    maxSayfa = sayfaSayilari.get(i);
                    maxIndex = i;
                }
            }

            if (maxIndex != -1) {
                System.out.println("En büyük sayfa sayısına sahip kitap:");
                System.out.println("Kitap Adı: " + kitapAdlari.get(maxIndex));
                System.out.println("Yazar: " + yazarlar.get(maxIndex));
                System.out.println("Yayınevi: " + yayinevleri.get(maxIndex));
                System.out.println("Sayfa Sayısı: " + sayfaSayilari.get(maxIndex));
            }
        }
    }

    public static void enKucukSayfaKitabiBul(List<String> kitapAdlari, List<String> yazarlar, List<Integer> sayfaSayilari, List<String> yayinevleri) {
        if (sayfaSayilari.isEmpty()) {
            System.out.println("Listede hiç kitap bulunmamaktadır.");
        } else {
            int minSayfa = Integer.MAX_VALUE;
            int minIndex = -1;

            for (int i = 0; i < sayfaSayilari.size(); i++) {
                if (sayfaSayilari.get(i) < minSayfa) {
                    minSayfa = sayfaSayilari.get(i);
                    minIndex = i;
                }
            }

            if (minIndex != -1) {
                System.out.println("En küçük sayfa sayısına sahip kitap:");
                System.out.println("Kitap Adı: " + kitapAdlari.get(minIndex));
                System.out.println("Yazar: " + yazarlar.get(minIndex));
                System.out.println("Yayınevi: " + yayinevleri.get(minIndex));
                System.out.println("Sayfa Sayısı: " + sayfaSayilari.get(minIndex));
            }
        }
    }
}