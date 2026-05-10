# Kapsamlı Olasılık ve İstatistik Analiz Motoru

Olasılık ve istatistik hesaplamaları için geliştirilmiş, CLI (Komut Satırı Arayüzü) tabanlı gelişmiş bir Java uygulamasıdır. Proje, hem temel rastgele örnekleme yöntemlerini simüle eden hem de girilen veri setleri üzerinde tam kapsamlı istatistiksel analizler (merkezi eğilim, dağılım ölçüleri, çeyreklikler) gerçekleştiren iki ana modülden oluşmaktadır.

## 🚀 Özellikler

Proje iki ana modül altında toplanmış geniş bir hesaplama yelpazesi sunar:

### Modül 1: Örneklem ve Temel Tablo Yöntemleri
* **Sistematik Rastgele Örnekleme:** Evren (N) ve örneklem (n) değerlerine göre periyodik (k) eleman seçimi.
* **Basit Rastgele Örnekleme:** Alt ve üst sınırlar belirlenerek benzersiz rastgele sayılar üretimi.
* **Tabakalı Rastgele Örnekleme:** Tabaka ağırlıklarına göre orantılı (n) örneklem seçimi.
* **Frekans Serisi ve Tablosu:** Sınıf aralığı (h), değişim genişliği (R), eklenik ve oransal frekansları hesaplayarak detaylı matris dökümü.

### Modül 2: Tam Kapsamlı İstatistik Analiz Motoru
* **Merkezi Eğilim Ölçüleri:** Aritmetik Ortalama, Medyan (Ortanca), Mod (Tepe Değer), Geometrik Ortalama, Harmonik Ortalama.
* **Dağılım ve Şekil Ölçüleri:** Örneklem Varyansı, Standart Sapma, Ortalama Mutlak Sapma (OMS), Çarpıklık (m3), Sivrilik (m4), Değişim Katsayısı.
* **Çeyreklik Hesaplamaları:** Frekans tablosu üzerinden interpolasyon yöntemiyle 1. Çeyreklik (Q1) ve 3. Çeyreklik (Q3) hesaplamaları.

## 🛠️ Kullanılan Teknolojiler
* **Dil:** Java (Tamamen yerleşik SE standartları kullanılmıştır, dış bağımlılık içermez.)
* **Sıralama Algoritması:** Yerleşik kütüphaneler yerine algoritmik temelleri göstermek amacıyla özel **Bubble Sort** (Kabarcık Sıralaması) fonksiyonu entegre edilmiştir.

## 💻 Kurulum ve Kullanım

1. Repoyu bilgisayarınıza klonlayın:
   ```bash
   git clone https://github.com/emirhan-uras/Olasilik-ve-Istatistik.git

2. **Proje dizinine giderek Java dosyasını derleyin:**
   ```bash
   javac IstatistikHesaplayici.java
   ```
   
3. **Uygulamayı başlatın:**
   ```bash
   java IstatistikHesaplayici
   ```

---
*Bu proje Karadeniz Teknik Üniversitesi, Yazılım Mühendisliği bölümü kapsamında geliştirilen algoritmik çalışmaları içermektedir.*
