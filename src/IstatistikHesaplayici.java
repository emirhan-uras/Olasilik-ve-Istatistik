import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class IstatistikHesaplayici {
    static Scanner scanner = new Scanner(System.in);
    static Random rnd = new Random();

    // Küsuratlı sayıları yuvarlamak için yardımcı metot
    static double round(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }

    // ==================================================================
    //                           ANA MENÜ
    // ==================================================================
    public static void main(String[] args) {
        while (true) {
            System.out.println("=========================================");
            System.out.println("      OLASILIK VE İSTATİSTİK PROJESİ     ");
            System.out.println("=========================================");
            System.out.println("Lütfen yapmak istediğiniz işlemi seçiniz:");
            System.out.println("1. Örneklem ve Temel Tablo Yöntemleri");
            System.out.println("2. Tam Kapsamlı İstatistik Analiz Motoru");
            System.out.println("0. Programdan Çıkış");
            System.out.println("=========================================");
            System.out.print("Seçiminiz: ");

            try {
                int anaSecim = Integer.parseInt(scanner.nextLine());

                if (anaSecim == 0) {
                    System.out.println("Programdan çıkılıyor. İyi günler!");
                    break;
                } else if (anaSecim == 1) {
                    orneklemMenu();
                } else if (anaSecim == 2) {
                    analizMotoru();
                } else {
                    System.out.println("Lütfen geçerli bir seçenek giriniz.\n");
                }
            } catch (Exception e) {
                System.out.println("Lütfen sadece rakam giriniz.\n");
            }
        }
    }

    // ==================================================================
    //           MODÜL 1: ÖRNEKLEM VE TEMEL TABLO MENÜSÜ
    // ==================================================================
    static void orneklemMenu() {
        while (true) {
            System.out.println("\n--- ÖRNEKLEM VE TEMEL TABLO YÖNTEMLERİ ---");
            System.out.println("1. Sistematik Rastgele Örnekleme");
            System.out.println("2. Basit Rastgele Örnekleme");
            System.out.println("3. Basit Seri");
            System.out.println("4. Tabakalı Rastgele Örnekleme");
            System.out.println("5. Frekans Serisi");
            System.out.println("6. Frekans Tablosu");
            System.out.println("0. Ana Menüye Dön");
            System.out.print("Seçiminiz: ");

            try {
                int secim = Integer.parseInt(scanner.nextLine());

                if (secim == 0) break;

                switch (secim) {
                    case 1: sistematikRasgeleOrnekleme(); break;
                    case 2: basitRasgeleOrnekleme(); break;
                    case 3: basitSeri(); break;
                    case 4: tabakaliRasgelOrnekleme(); break;
                    case 5: frekansSerisi(); break;
                    case 6: frekansTablosu(); break;
                    default: System.out.println("Lütfen geçerli bir sayı giriniz.\n"); break;
                }
            } catch (Exception e) {
                System.out.println("Lütfen sadece rakam giriniz.\n");
            }
        }
    }

    // --- MODÜL 1 FONKSİYONLARI ---

    static void sistematikRasgeleOrnekleme() {
        int N, n, k;
        while (true) {
            System.out.println("\nLütfen evreninizin büyüklüğünü giriniz:");
            N = Integer.parseInt(scanner.nextLine());
            System.out.println("Lütfen örneklem hacmini giriniz:");
            n = Integer.parseInt(scanner.nextLine());
            if (n == 0 || n > N) {
                System.out.println("Lütfen girdiğiniz örneklem hacmi evrenden büyük olmasın ve 0'dan farklı bir sayı olsun.");
            } else {
                break;
            }
        }
        k = N / n;
        int[] kume = new int[n];

        int bsg = 1;
        if (k > 1) {
            bsg = rnd.nextInt(k - 1) + 1;
        }

        System.out.println("\nSeçilen Elemanlar:");
        for (int i = 0; i < n; i++) {
            kume[i] = bsg;
            System.out.println(kume[i]);
            bsg += k;
        }
    }

    static void basitRasgeleOrnekleme() {
        int k, b;
        while (true) {
            System.out.println("\nAlt sınırı giriniz:");
            k = Integer.parseInt(scanner.nextLine());
            System.out.println("Üst sınırı giriniz:");
            b = Integer.parseInt(scanner.nextLine());
            if (k < 0) {
                System.out.println("Sıfırdan küçük bir alt sınır giremezsiniz.");
                continue;
            } else {
                break;
            }
        }
        System.out.println("Üretilecek sayı adedini giriniz:");
        int n = Integer.parseInt(scanner.nextLine());
        int[] dizi = new int[n];
        int s;
        int t = (b - k) + 1;
        boolean mevcut;
        int sayac = 0;

        if (n <= t) {
            while (sayac < n) {
                s = rnd.nextInt((b + 1) - k) + k;
                mevcut = false;
                for (int i = 0; i < n; i++) {
                    if (dizi[i] == s) {
                        mevcut = true;
                        break;
                    }
                }
                if (!mevcut) {
                    dizi[sayac] = s;
                    sayac++;
                }
            }
        } else {
            for (int i = 0; i < n; i++) {
                dizi[i] = rnd.nextInt((b + 1) - k) + k;
            }
        }
        System.out.println("\nSeçilen Rastgele Sayılar:");
        for (int i = 0; i < n; i++) {
            System.out.print(dizi[i] + " ");
        }
        System.out.println("\n");
    }

    static void basitSeri() {
        int adet;
        while (true) {
            System.out.println("\nLütfen kaç adet veri gireceğinizi yazınız:");
            adet = Integer.parseInt(scanner.nextLine());
            if (adet < 0) {
                System.out.println("Lütfen 0'dan büyük bir sayı giriniz.");
            } else if (adet == 0) {
                System.out.println("Fonksiyondan çıkarıldınız.");
                return;
            } else {
                break;
            }
        }
        double[] dizi = new double[adet];
        int x;
        for (int i = 0; i < dizi.length; i++) {
            System.out.println("Lütfen " + i + ". indise girilecek sayıyı giriniz:");
            x = Integer.parseInt(scanner.nextLine());
            dizi[i] = x;
        }
        dizi = kabarcik_siralama(dizi);
        System.out.println("\nBasit Seri Çıktısı:");
        for (int i = 0; i < dizi.length; i++) {
            System.out.print(dizi[i] + " ");
        }
        System.out.println("\n");
    }

    static void tabakaliRasgelOrnekleme() {
        System.out.println("\nLütfen tabaka sayısını giriniz:");
        int tabakaSayisi = Integer.parseInt(scanner.nextLine());

        int[] tabakaN = new int[tabakaSayisi];
        int toplamN = 0;

        for (int i = 0; i < tabakaSayisi; i++) {
            System.out.println((i + 1) + ". tabakanın toplam eleman sayısını (N" + (i + 1) + ") giriniz:");
            tabakaN[i] = Integer.parseInt(scanner.nextLine());
            toplamN += tabakaN[i];
        }

        System.out.println("Hesaplanan Toplam Evren Büyüklüğü (N) = " + toplamN);
        System.out.println("Lütfen oluşturmak istediğiniz toplam örneklem hacmini (n) giriniz:");
        int n = Integer.parseInt(scanner.nextLine());

        if (n > toplamN || n <= 0) {
            System.out.println("Hata: Örneklem hacmi evrenden büyük veya 0'dan küçük olamaz!");
            return;
        }

        System.out.println("\n--- Tabakalı Örneklem Dağılımı ---");
        int secilenToplam = 0;
        int[] tabaka_n = new int[tabakaSayisi];

        for (int i = 0; i < tabakaSayisi; i++) {
            double oran = (double) tabakaN[i] / toplamN;
            tabaka_n[i] = (int) Math.round(n * oran);
            secilenToplam += tabaka_n[i];
        }

        while(secilenToplam < n) {
            tabaka_n[0]++; secilenToplam++;
        }
        while(secilenToplam > n) {
            tabaka_n[0]--; secilenToplam--;
        }

        int altSinir = 1;
        for (int i = 0; i < tabakaSayisi; i++) {
            int ustSinir = altSinir + tabakaN[i] - 1;

            System.out.println((i + 1) + ". Tabaka (Evrendeki Aralığı: " + altSinir + " - " + ustSinir + ") | Seçilecek eleman sayısı: " + tabaka_n[i]);
            System.out.print("Bu tabakadan rastgele seçilen eleman sıraları: ");

            for (int j = 0; j < tabaka_n[i]; j++) {
                int secilen = rnd.nextInt((ustSinir - altSinir) + 1) + altSinir;
                System.out.print(secilen + " ");
            }
            System.out.println("\n");

            altSinir = ustSinir + 1;
        }
    }

    static void frekansSerisi() {
        int adet;
        while (true) {
            System.out.println("\nLütfen kaç adet sayı gireceğinizi yazınız:");
            adet = Integer.parseInt(scanner.nextLine());
            if (adet == 0) {
                System.out.println("Fonksiyondan çıkarılıyorsunuz.");
                return;
            } else if (adet < 0) {
                System.out.println("0'dan büyük sayı giriniz.");
                continue;
            } else {
                break;
            }
        }
        double[] tarama = new double[adet];
        for (int i = 0; i < adet; i++) {
            System.out.println(i + ". sayıyı giriniz:");
            tarama[i] = Double.parseDouble(scanner.nextLine());
        }
        double[][] donen = frekans(tarama, adet);

        System.out.println("\nFrekans Serisi Çıktısı:");
        for (int i = 0; i < donen.length; i++) {
            if (donen[i][1] != 0) {
                System.out.println(donen[i][0] + "\t" + donen[i][1]);
            }
        }
        System.out.println();
    }

    static double[] frekansTablosu() {
        int adet;
        while (true) {
            System.out.println("\nLütfen kaç adet veri gireceğinizi yazınız:");
            adet = Integer.parseInt(scanner.nextLine());
            if (adet <= 0) {
                System.out.println("Lütfen 0'dan büyük bir sayı giriniz.");
            } else {
                break;
            }
        }

        double[] dizi = new double[adet];
        for (int i = 0; i < adet; i++) {
            System.out.print((i + 1) + ". Veriyi giriniz --> ");
            dizi[i] = Double.parseDouble(scanner.nextLine());
        }

        dizi = kabarcik_siralama(dizi);

        List<Integer> cd = new ArrayList<>();
        for (int i = 1; i <= adet; i++) {
            if (adet % i == 0) {
                cd.add(i);
            }
        }
        int[] carpan = new int[cd.size()];
        for (int i = 0; i < cd.size(); i++) {
            carpan[i] = cd.get(i);
        }
        cd.clear();

        int[][] satir_sutun = ssh(carpan, adet);
        int x = satir_sutun[0][0];
        int y = satir_sutun[0][1];
        int c = 0;
        double[][] tablodizi = new double[y][x];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                tablodizi[j][i] = dizi[c];
                c++;
            }
        }

        System.out.println("\n--- Sıralanmış Veri Matrisi ---");
        c = 0;
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                System.out.print(tablodizi[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();

        int maxBasamak = 0;
        for (double v : dizi) {
            String metin = String.valueOf(v);
            if (metin.contains(".")) {
                String kusurat = metin.split("\\.")[1];
                if (!kusurat.equals("0")) {
                    maxBasamak = Math.max(maxBasamak, kusurat.length());
                }
            }
        }

        double birim = 1.0;
        if (maxBasamak > 0) {
            birim = 1.0 / Math.pow(10, maxBasamak);
        }

        double R = dizi[adet - 1] - dizi[0];
        double k_hesap = Math.ceil(Math.sqrt(adet));
        int z = (int) k_hesap;
        double h = Math.ceil(R / k_hesap);
        if (h == 0) h = birim;

        System.out.println("Değişim Genişliği (R) = " + round(R, 3));
        System.out.println("Sınıf Sayısı (k) = " + z);
        System.out.println("Sınıf Aralığı (h) = " + h);
        System.out.println("Veri Hassasiyeti (Birim) = " + birim + "\n");

        double[][] tablo = new double[z][9];

        double altLimit = dizi[0];
        for (int i = 0; i < z; i++) {
            tablo[i][2] = altLimit;
            tablo[i][3] = altLimit + h - birim;

            tablo[i][0] = tablo[i][2] - (birim / 2.0);
            tablo[i][1] = tablo[i][3] + (birim / 2.0);

            tablo[i][5] = (tablo[i][2] + tablo[i][3]) / 2.0;

            altLimit += h;
        }

        for (int i = 0; i < z; i++) {
            for (int j = 0; j < adet; j++) {
                if (round(dizi[j], 4) >= round(tablo[i][2], 4) && round(dizi[j], 4) <= round(tablo[i][3], 4)) {
                    tablo[i][4]++;
                }
            }
        }

        tablo[0][6] = tablo[0][4];
        for (int i = 1; i < z; i++) {
            tablo[i][6] = tablo[i][4] + tablo[i - 1][6];
        }

        for (int i = 0; i < z; i++) {
            tablo[i][7] = round((tablo[i][4] / adet), 2);
            tablo[i][8] = round((tablo[i][6] / adet), 2);
        }

        System.out.println("Sınıf Sınırları      Sınıf Limitleri      Frekans    SON       E.F.      O.F.      E.O.F");
        System.out.println("Alt      Üst         Alt      Üst         (f)        -         -         -         -");
        System.out.println("------------------------------------------------------------------------------------------");

        for (int i = 0; i < z; i++) {
            System.out.printf("%-8.2f %-11.2f %-8.2f %-11.2f %-10.0f %-9.2f %-9.0f %-9.2f %-9.2f\n",
                    tablo[i][0], tablo[i][1], tablo[i][2], tablo[i][3],
                    tablo[i][4], tablo[i][5], tablo[i][6], tablo[i][7], tablo[i][8]);
        }
        System.out.println();

        return dizi;
    }

    // ==================================================================
    //                   MODÜL 2: İSTATİSTİKSEL ANALİZ MOTORU
    // ==================================================================
    static void analizMotoru() {
        System.out.println("\n=========================================");
        System.out.println("   TAM KAPSAMLI İSTATİSTİK ANALİZ MOTORU ");
        System.out.println("=========================================");

        int adet;
        while (true) {
            System.out.println("Lütfen veri setinizde kaç adet sayı olduğunu giriniz:");
            try {
                adet = Integer.parseInt(scanner.nextLine());
                if (adet <= 1) {
                    System.out.println("Hesaplama yapılabilmesi için en az 2 sayı girmelisiniz.");
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Lütfen geçerli bir tam sayı giriniz.");
            }
        }

        double[] dizi = new double[adet];
        System.out.println("\nLütfen verilerinizi giriniz:");
        for (int i = 0; i < adet; i++) {
            System.out.print((i + 1) + ". Veri: ");
            dizi[i] = Double.parseDouble(scanner.nextLine());
        }


        dizi = kabarcik_siralama(dizi);

        System.out.println("\n=========================================");
        System.out.println("             SERİLER VE TABLOLAR           ");
        System.out.println("=========================================\n");

        basitSeriYazdir(dizi);
        frekansSerisiYazdir(dizi, adet);
        double[][] frekansTablo = frekansTablosuOlusturYazdir(dizi, adet);


        double aritmetikOrt = AritmetikOrt(dizi);
        double medyanVal = medyan(dizi, adet);
        double modVal = mod(dizi, adet);
        double geoOrt = geohesap(dizi);
        double harmonikOrt = harmonik(dizi, adet);

        double varyans = orneklemvaryans(dizi, adet);
        double sapma = Math.sqrt(varyans);
        double oms = OMS(dizi, adet);
        double carpiklik = m3(dizi, adet);
        double sivrilik = m4(dizi, adet);
        double degisimKatsayisi = (sapma / aritmetikOrt) * 100;


        double[] ceyreklikler = DortteBirlikTablodan(frekansTablo, adet);


        System.out.println("\n=========================================");
        System.out.println("         İSTATİSTİKSEL ANALİZ RAPORU       ");
        System.out.println("=========================================");

        System.out.println(">>> MERKEZİ EĞİLİM ÖLÇÜLERİ <<<");
        System.out.println("Aritmetik Ortalama : " + round(aritmetikOrt, 3));
        System.out.println("Medyan (Ortanca)   : " + round(medyanVal, 3));
        System.out.println("Mod (Tepe Değer)   : " + round(modVal, 3));
        System.out.println("Geometrik Ortalama : " + round(geoOrt, 3));
        System.out.println("Harmonik Ortalama  : " + round(harmonikOrt, 3));

        System.out.println("\n>>> DAĞILIM VE ŞEKİL ÖLÇÜLERİ <<<");
        System.out.println("Örneklem Varyansı  : " + round(varyans, 3));
        System.out.println("Standart Sapma     : " + round(sapma, 3));
        System.out.println("Ort. Mutlak Sapma  : " + round(oms, 3));
        System.out.println("Çarpıklık (m3)     : " + round(carpiklik, 3));
        System.out.println("Sivrilik (m4)      : " + round(sivrilik, 3));
        System.out.println("Değişim Katsayısı  : % " + round(degisimKatsayisi, 3));

        System.out.println("\n>>> ÇEYREKLİKLER (Tablo Üzerinden) <<<");
        System.out.println("1. Çeyreklik (Q1)  : " + round(ceyreklikler[0], 3));
        System.out.println("3. Çeyreklik (Q3)  : " + round(ceyreklikler[1], 3));
        System.out.println("=========================================\n");
        System.out.println("İşlem tamamlandı. Ana menüye dönmek için ENTER'a basınız...");
        scanner.nextLine();
    }

    // --- MODÜL 2 İÇİN YARDIMCI TABLO VE ÇİZİM METOTLARI ---
    static void basitSeriYazdir(double[] dizi) {
        System.out.println("--- 1. Basit Seri (Sıralı Veri) ---");
        System.out.print("[ ");
        for (double v : dizi) System.out.print(v + "  ");
        System.out.println("]\n");
    }

    static void frekansSerisiYazdir(double[] dizi, int adet) {
        System.out.println("--- 2. Frekans Serisi ---");
        double[][] donen = frekans(dizi, adet);
        System.out.println("Değer\tFrekans(f)");
        for (int i = 0; i < donen.length; i++) {
            System.out.println(donen[i][0] + "\t" + (int)donen[i][1]);
        }
        System.out.println();
    }

    static double[][] frekansTablosuOlusturYazdir(double[] dizi, int adet) {
        System.out.println("--- 3. Frekans Tablosu ---");

        double birim = 1.0;
        int maxBasamak = 0;
        for (double v : dizi) {
            String metin = String.valueOf(v);
            if (metin.contains(".")) {
                String kusurat = metin.split("\\.")[1];
                if (!kusurat.equals("0")) {
                    maxBasamak = Math.max(maxBasamak, kusurat.length());
                }
            }
        }
        if (maxBasamak > 0) {
            birim = 1.0 / Math.pow(10, maxBasamak);
        }

        double R = dizi[adet - 1] - dizi[0];
        double k_hesap = Math.ceil(Math.sqrt(adet));
        int z = (int) k_hesap;
        double h = Math.ceil(R / k_hesap);
        if (h == 0) h = birim;

        System.out.println("Değişim Genişliği (R) = " + round(R, 3));
        System.out.println("Sınıf Sayısı (k) = " + z);
        System.out.println("Sınıf Aralığı (h) = " + h);
        System.out.println("Veri Hassasiyeti (Birim) = " + birim + "\n");

        double[][] tablo = new double[z][9];
        double altLimit = dizi[0];
        for (int i = 0; i < z; i++) {
            tablo[i][2] = altLimit;
            tablo[i][3] = altLimit + h - birim;
            tablo[i][0] = tablo[i][2] - (birim / 2.0);
            tablo[i][1] = tablo[i][3] + (birim / 2.0);
            tablo[i][5] = (tablo[i][2] + tablo[i][3]) / 2.0;
            altLimit += h;
        }

        for (int i = 0; i < z; i++) {
            for (int j = 0; j < adet; j++) {
                if (round(dizi[j], 4) >= round(tablo[i][2], 4) && round(dizi[j], 4) <= round(tablo[i][3], 4)) {
                    tablo[i][4]++;
                }
            }
        }

        tablo[0][6] = tablo[0][4];
        for (int i = 1; i < z; i++) {
            tablo[i][6] = tablo[i][4] + tablo[i - 1][6];
        }

        for (int i = 0; i < z; i++) {
            tablo[i][7] = round((tablo[i][4] / adet), 2);
            tablo[i][8] = round((tablo[i][6] / adet), 2);
        }

        System.out.println("Sınıf Sınırları      Sınıf Limitleri      Frekans    SON       E.F.      O.F.      E.O.F");
        System.out.println("Alt      Üst         Alt      Üst         (f)        -         -         -         -");
        System.out.println("------------------------------------------------------------------------------------------");
        for (int i = 0; i < z; i++) {
            System.out.printf("%-8.2f %-11.2f %-8.2f %-11.2f %-10.0f %-9.2f %-9.0f %-9.2f %-9.2f\n",
                    tablo[i][0], tablo[i][1], tablo[i][2], tablo[i][3],
                    tablo[i][4], tablo[i][5], tablo[i][6], tablo[i][7], tablo[i][8]);
        }
        System.out.println();
        return tablo;
    }

    // --- MODÜL 2 İÇİN HESAPLAMA METOTLARI ---
    static double AritmetikOrt(double[] dizi) {
        double top = 0;
        for (double v : dizi) top += v;
        return top / dizi.length;
    }

    static double medyan(double[] dizi, int adet) {
        if (adet % 2 == 1) return dizi[adet / 2];
        else return (dizi[adet / 2] + dizi[(adet / 2) - 1]) / 2.0;
    }

    static double mod(double[] dizi, int adet) {
        double maxFrekans = 0, modSayisi = dizi[0];
        double[][] frekanslar = frekans(dizi, adet);
        for (int i = 0; i < frekanslar.length; i++) {
            if (frekanslar[i][1] > maxFrekans) {
                modSayisi = frekanslar[i][0];
                maxFrekans = frekanslar[i][1];
            }
        }
        return modSayisi;
    }

    static double geohesap(double[] dizi) {
        double carp = 1;
        for (double v : dizi) carp *= v;
        return Math.pow(carp, 1.0 / dizi.length);
    }

    static double harmonik(double[] dizi, int adet) {
        double top = 0;
        for (double v : dizi) top += 1 / v;
        return adet / top;
    }

    static double orneklemvaryans(double[] dizi, int adet) {
        double ao = AritmetikOrt(dizi);
        double top = 0;
        for (double v : dizi) top += Math.pow((v - ao), 2.0);
        return top / (adet - 1);
    }

    static double OMS(double[] dizi, int adet) {
        double ao = AritmetikOrt(dizi);
        double top = 0;
        for (double v : dizi) top += Math.abs(v - ao);
        return top / adet;
    }

    static double m3(double[] dizi, int adet) {
        double ao = AritmetikOrt(dizi);
        double top = 0;
        for (double v : dizi) top += Math.pow((v - ao), 3.0);
        return top / (adet - 1);
    }

    static double m4(double[] dizi, int adet) {
        double ao = AritmetikOrt(dizi);
        double top = 0;
        for (double v : dizi) top += Math.pow((v - ao), 4.0);
        return top / (adet - 1);
    }

    static double[] DortteBirlikTablodan(double[][] tablo, int adet) {
        double q1_sirasi = adet / 4.0;
        double q3_sirasi = (3.0 * adet) / 4.0;

        int q1_sinif_indeksi = 0;
        int q3_sinif_indeksi = 0;

        for (int i = 0; i < tablo.length; i++) {
            if (tablo[i][6] >= q1_sirasi) {
                q1_sinif_indeksi = i;
                break;
            }
        }
        for (int i = 0; i < tablo.length; i++) {
            if (tablo[i][6] >= q3_sirasi) {
                q3_sinif_indeksi = i;
                break;
            }
        }

        double l1 = tablo[q1_sinif_indeksi][0];
        double fa1 = (q1_sinif_indeksi == 0) ? 0 : tablo[q1_sinif_indeksi - 1][6];
        double f1 = tablo[q1_sinif_indeksi][4];
        double h1 = tablo[q1_sinif_indeksi][1] - tablo[q1_sinif_indeksi][0];
        double q1_degeri = l1 + (((q1_sirasi - fa1) * h1) / f1);

        double l3 = tablo[q3_sinif_indeksi][0];
        double fa3 = (q3_sinif_indeksi == 0) ? 0 : tablo[q3_sinif_indeksi - 1][6];
        double f3 = tablo[q3_sinif_indeksi][4];
        double h3 = tablo[q3_sinif_indeksi][1] - tablo[q3_sinif_indeksi][0];
        double q3_degeri = l3 + (((q3_sirasi - fa3) * h3) / f3);

        return new double[]{q1_degeri, q3_degeri};
    }

    // ==================================================================
    //                  GENEL YARDIMCI METOTLAR
    // ==================================================================

    static int[][] ssh(int[] dizi, int adet) {
        int satir = 0;
        int sutun = 0;
        for (int i = 0; i < adet; i++) {
            for (int j = 0; j < adet; j++) {
                if (i * j == adet) {
                    if (satir == 0 && sutun == 0) {
                        satir = i;
                        sutun = j;
                    } else if (Math.abs(i - j) < Math.abs(satir - sutun)) {
                        satir = i;
                        sutun = j;
                    }
                }
            }
        }
        int[][] x = new int[1][2];
        x[0][0] = satir;
        x[0][1] = sutun;
        return x;
    }

    static double[] kabarcik_siralama(double[] gelendizi) {
        double swp;
        for (int i = 0; i < gelendizi.length; i++) {
            for (int j = 0; j < gelendizi.length - 1; j++) {
                if (gelendizi[j] > gelendizi[j + 1]) {
                    swp = gelendizi[j];
                    gelendizi[j] = gelendizi[j + 1];
                    gelendizi[j + 1] = swp;
                }
            }
        }
        return gelendizi;
    }

    static double[][] frekans(double[] gelendizi, int adet) {
        int say = 0;
        double[][] dizi = new double[adet][2];
        for (int i = 0; i < adet; i++) {
            double sayi = gelendizi[i];
            boolean varmi = false;
            for (int j = 0; j < say; j++) {
                if (dizi[j][0] == sayi) {
                    dizi[j][1]++;
                    varmi = true;
                    break;
                }
            }
            if (!varmi) {
                dizi[say][0] = sayi;
                dizi[say][1] = 1;
                say++;
            }
        }
        double[][] sonuc = new double[say][2];
        for (int i = 0; i < say; i++) {
            sonuc[i][0] = dizi[i][0];
            sonuc[i][1] = dizi[i][1];
        }
        return sonuc;
    }
}