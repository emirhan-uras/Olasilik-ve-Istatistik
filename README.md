# Statistical Sampling and Frequency Calculator

Olasılık ve istatistik hesaplamaları için geliştirilmiş, konsol tabanlı (CLI) bir Java uygulamasıdır. Kullanıcılardan alınan verilerle çeşitli rastgele örnekleme yöntemlerini simüle eder ve frekans dağılımlarını hesaplar.

## 🚀 Özellikler

Proje, temel istatistiksel işlemleri gerçekleştirmek için aşağıdaki altı ana modüle sahiptir:

1. **Sistematik Rastgele Örnekleme:** Belirli bir evren (N) ve örneklem hacmi (n) üzerinden $k$ periyodu ile sistematik seçim yapar.
2. **Basit Rastgele Örnekleme:** Belirtilen alt ve üst sınırlar arasında, tekrar etmeyen benzersiz rastgele sayılar üretir.
3. **Basit Seri:** Kullanıcıdan alınan verileri yerleşik fonksiyonlar yerine Bubble Sort algoritması kullanarak küçükten büyüğe sıralar.
4. **Tabakalı Rastgele Örnekleme:** Farklı tabakaların evren içindeki ağırlıklarına (N1, N2...) göre orantılı olarak rastgele eleman seçimi yapar.
5. **Frekans Serisi:** Girilen veri setindeki her bir elemanın frekansını (tekrar sayısını) gruplandırarak hesaplar.
6. **Frekans Tablosu:** Sınıf sayısını, sınıf aralığını, değişim genişliğini (R) ve birim hassasiyetini hesaplayarak detaylı bir frekans dağılım tablosu oluşturur (Sınıf Limitleri, Oransal Frekans, Eklenik Frekans vb.).

## 🛠️ Kullanılan Teknolojiler

* **Dil:** Java
* **Standart Kütüphaneler:** `java.util.Scanner`, `java.util.Random`, `java.util.List`, `java.util.ArrayList`

## 💻 Kurulum ve Kullanım

Projeyi yerel makinenizde derlemek ve çalıştırmak için aşağıdaki adımları izleyebilirsiniz:

1. Repoyu bilgisayarınıza klonlayın:
   ```bash
   git clone [https://github.com/kullaniciadi/repo-adi.git](https://github.com/kullaniciadi/repo-adi.git)
