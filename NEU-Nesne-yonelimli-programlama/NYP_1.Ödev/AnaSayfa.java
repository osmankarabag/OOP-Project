
import java.util.Scanner;

// eclipse icin yazdigim wipeConsole fonksiyonu icin gerekli moduller.
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;


public class AnaSayfa {
	
	
	public static int clear = 0;
	
	static Departman[] departmanlar;
	static public int dp_adet;
	
	static public int enb=10;
	static public int enkc=150;
  
    static Scanner input = new Scanner(System.in);
    
    
    public static void main(String[] args) throws AWTException{
    	
    	
        departmanlar = DpEkle();
        
       
        int secim = 0;           
        String add;              
        while (true) {
        	        	
        	wipeConsole();
        	
        	// menu.
        	 System.out.println("\n -  Sirket (Ana menu) -");
             System.out.println("\n\n  1-) Tum Departmanlari Listele");
             System.out.println("\n    2-) Departman Ara");
             System.out.println("\n    3-) Personel Ara");
             System.out.println("\n    4-) Proje Ara");
             System.out.println("\n    5-) Ya�a G�re Personel/Personelleri Ara");
             System.out.println("\n    6-) Ya� Bilgisine G�re Personelleri Analiz Et");
             System.out.println("\n    7-) Proje S�resine G�re Projeleri Bul");
             System.out.println("\n    8-) Proje Maliyetine G�re Projeleri Bul");
             System.out.println("\n    9-) Proje Maliyetine G�re Projeleri Analiz Et");
             System.out.println("\n    10-) Cikis");
             System.out.printf("\n       Secim : ");
                      
            while (true) {
            	            	
                try {
                    secim = Integer.parseInt(input.nextLine());
                                       
                    if (secim <= 0 || secim >= 11) {
                        secim = Integer.parseInt("Eror-404");
                    }
                } catch (NumberFormatException ex) { 
                	                                	
                	wipeConsole();

                    System.out.printf("\n       Seciminiz 0 ile 11 arasinda bir Int tam sayi olamali. Tekrar secim yapmak i�in Enter'e basiniz.  ");
                    input.nextLine();

                    wipeConsole();
                    System.out.println("\n -  Sirket (Ana menu) -");
                    System.out.println("\n\n  1-) Tum Departmanlari Listele");
                    System.out.println("\n    2-) Departman Ara");
                    System.out.println("\n    3-) Personel Ara");
                    System.out.println("\n    4-) Proje Ara");
                    System.out.println("\n    5-) Ya�a G�re Personel/Personelleri Ara");
                    System.out.println("\n    6-) Ya� Bilgisine G�re Personelleri Analiz Et");
                    System.out.println("\n    7-) Proje S�resine G�re Projeleri Bul");
                    System.out.println("\n    8-) Proje Maliyetine G�re Projeleri Bul");
                    System.out.println("\n    9-) Proje Maliyetine G�re Projeleri Analiz Et");
                    System.out.println("\n    10-) Cikis");
                    System.out.printf("\n       Secim : ");

                    continue;
                }
                break;
            }
            
            // girilen secim degiskenine gore kod bloklari haraket ettirilir.
            switch (secim) {
            	
            	// departman listele.
                case 1:
                	
                	wipeConsole();
                    System.out.println("\n  Sirket (Departmanlari Listele) -\n\n");

                    for (int i = 0; i < Departman.getDepSayi(); i++) {
                        listele(departmanlar[i], i);
                        System.out.println();
                        System.out.println();
                    }

                    System.out.printf("      Ana menuye donmek icin Enter'e basiniz. ");
                    input.nextLine();

                    break;
                
                // departman ara
                case 2:
                	
                	wipeConsole();
                    System.out.println("\n  Sirket (Departman Ara) -\n\n");

                    System.out.printf("     Aranacak Departman Adi : ");
                    add = input.nextLine();
                    
                    wipeConsole();
                    System.out.println("\n - Sirket (Departman Ara) -\n\n");

                    secim = 0;

                    for (int i = 0; i < Departman.getDepSayi(); i++) {

                        if (departmanlar[i].getDepAd().equals(add)) {

                            listele(departmanlar[i], -10);

                            System.out.println();
                            System.out.println();

                            secim = 1;
                        }
                    }

                    if (secim == 0) {

                        System.out.println("      Departman bulunamadi. Ana menuye donmek icin Enter'e basiniz.");
                        input.nextLine();
                        
                    } else {

                        System.out.printf("      Ana menuye donmek icin Enter'e basiniz. ");
                        input.nextLine();
                    }

                    break;
                
                // personel ara
                case 3:
                	
                	wipeConsole();
                    System.out.println("\n - Sirket (Personel Ara) -\n\n");

                    System.out.printf("     Aranacak Personel Adi : ");
                    add = input.nextLine();

                    wipeConsole();
                    System.out.println("\n -  Sirket (Personel Ara) -\n\n");

                    secim = 0;

                    for (int i = 0; i < Departman.getDepSayi(); i++) {

                        for (int j = 0; j < departmanlar[i].getInt_personeller(); j++) {

                            if (departmanlar[i].getPersoneller(j).getPerAd().equals(add)) {

                                pr_listele(departmanlar[i].getPersoneller(j), departmanlar[i]);

                                secim = 1;

                            }

                        }
                    }

                    if (secim == 0) {

                        System.out.println("      Personel bulunamadi. Ana menuye donmek icin Enter'e basiniz.");
                        input.nextLine();
                    } else {

                        System.out.printf("      Ana menuye donmek icin Enter'e basiniz. ");
                        input.nextLine();

                    }
                    break;
                
             
                case 4:
                	
                	wipeConsole();
                    System.out.println("\n  Sirket (proje Ara) -\n\n");

                    System.out.printf("     Aranacak proje ad� : ");
                    add = input.nextLine();

                    wipeConsole();
                    System.out.println("\n  Sirket (proje ad� ara) -\n\n");

                    secim = 0;

                    for (int i = 0; i < Departman.getDepSayi(); i++) {

                        for (int j = 0; j < departmanlar[i].getInt_projeler(); j++) {

                            if (departmanlar[i].getProjeler(j).getProjeAd().equals(add)) {

                                proje_listele(departmanlar[i].getProjeler(j), departmanlar[i]);

                                secim = 1;

                            }

                        }
                    }

                    if (secim == 0) {

                        System.out.println("      Proje bulunamadi. Ana menuye donmek icin Enter'e basiniz.");
                        input.nextLine();
                    } else {

                        System.out.printf("      Ana menuye donmek icin Enter'e basiniz. ");
                        input.nextLine();

                    }
                    break;
               
                case 5:                
                	System.out.println("ya� bilgisine g�re personelleri bulma");    	
                    break;
                case 6:
    	            System.out.println("ya� bilgisine g�re personelleri analiz et");             	
                    break;
                case 7:
    	            System.out.println("proje s�resine g�re projeleri bulma");              	
                    break;
                case 8:
    	            System.out.println("proje maliyetine g�re projeleri bulma");
 	 	
                    break;
               case 9:
   	                System.out.println("proje maliyetine g�re projeleri analiz et");
 	 	
                    break;
 	
                
                case 10:
                	wipeConsole();
                    return;

            }
        }

    }
    
    public static Departman[] DpEkle() throws AWTException{

        String ad;
        
        wipeConsole();
        
        System.out.println("\n  Sirket (Departman Ekle) -");
        
        System.out.print("\n    Ka� adet departman eklenecek : ");
        
        while (true) {

            try {

                dp_adet = Integer.parseInt(input.nextLine());
            } catch (NumberFormatException ex) {
            	
            	wipeConsole();
                System.out.printf("\n     Eklenecek departman adeti, Int veri tipinde olmali. Tekrar Departman adeti girmek icin Enter'e basiniz. ");
                input.nextLine();
                
                wipeConsole();
                System.out.println("\n  Sirket (Departman Ekle) -");
                System.out.print("\n    Ka� adet departman eklenecek : ");
                continue;
            }
            
            if(dp_adet<0) {
            	
            	wipeConsole();
                System.out.printf("\n     Eklenecek departman adeti 0 dan buyuk olmalidir. Tekrar Departman adeti girmek icin Enter'e basiniz. ");
                input.nextLine();
                
                wipeConsole();
                System.out.println("\n  Sirket (Departman Ekle) -");
                System.out.print("\n    Ka� adet departman eklenecek : ");
                continue;
            	
            }
            
            
            break;
        }
        
  
        Departman[] departmanlar = new Departman[dp_adet];
        
    
        for(int i=1;i<dp_adet+1;i++){ 
        	
        	departmanlar[i-1] = new Departman();
        	
        	wipeConsole();
            
            System.out.println("\n  Sirket (Departman Ekle) -");

            System.out.printf("\n   " + i + ". Departman no : ");

            while (true) {
            	
            	if(departmanlar[i-1].setDepNo(input.nextLine())==0) {
            		break;
            	}
            	
            	else {
            		
            		wipeConsole();
            		System.out.printf("\n     Departman no, Int veri tipinde olmali. Tekrar Departman no girmek icin Enter'e basiniz. ");
            		input.nextLine();
                    
                    wipeConsole();
                    System.out.println("\n  Sirket (Departman Ekle) -");
                    System.out.printf("\n   " + i + ". Departman no : ");
                    
            		
            	}
            }

            System.out.printf("\n   " + i + ". Departman ad : ");
            ad = input.nextLine();
            
            departmanlar[i-1].setDepAd(ad);
            
            wipeConsole();
            
            System.out.println("\n  Sirket (Personel Ekle) -");
            
            System.out.print("\n    Ka� adet personel eklenecek : ");
            
            while (true) {
            	
            	if(departmanlar[i-1].setInt_personeller(input.nextLine())==0) {
            		break;
            	}
            	
            	else {
            		
            		wipeConsole();
                    System.out.printf("\n     Eklenecek personel adeti, Int veri tipinde olmali ve 0 dan buyuk olmali. Tekrar personel adeti girmek icin Enter'e basiniz. ");
                    input.nextLine();
                    
                    wipeConsole();
                    System.out.println("\n  Sirket (Departman Ekle) -");
                    System.out.print("\n    Ka� adet personel eklenecek : ");
            		
            	}

            }
            
    
            departmanlar[i-1].setPersoneller();

            String ad1;
            String syd;
            int yas;

            
      
            for(int j=1; j<departmanlar[i-1].getInt_personeller()+1;j++){
            	
            	wipeConsole();

                System.out.println("\n  Sirket (Kisi Ekle) -");
                System.out.println("\n   " + i + ". Departman no : " + departmanlar[i-1].getDepNo());
                System.out.println("\n   " + i + ". Departman ad : " + ad);

                System.out.printf("\n     " + j + ". Personel Adi : ");
                ad1 = input.nextLine();

                System.out.printf("\n     " + j + ". Personel Soyadi : ");
                syd = input.nextLine();

                System.out.printf("\n     " + j + ". Personel Yasi : ");

                while (true) {
                	
                	int kn = 0;
                	yas = 0;

                    try {

                        yas = Integer.parseInt(input.nextLine());
                    } catch (NumberFormatException ex) {
                    	
                    	kn=1;
                    	
                    }
                    
                    if(kn!=1) {
                    	
                    	if(yas<16) {
                        	
                        	kn=9;
                        }
                    }
                    
                    if(kn==1 || kn==9) {
                    	
                    	wipeConsole();
                    	
                    	if(kn==1) {
                            
                    		System.out.printf("\n        Personel yasi, Int veri tipinde olmalidir. Tekrar Personel yasi girmek icin Enter'e basiniz. ");

                    	}
                    	
                    	else {
                    		System.out.printf("\n        Personel yasi minumum 16 olabilir. Tekrar Personel yasi girmek icin Enter'e basiniz. ");

                    	}
                    	
                        input.nextLine();
                        
                        wipeConsole();
                        System.out.println("\n  Sirket (Kisi Ekle) -");
                        System.out.println("\n   " + j + ". Departman no : " + departmanlar[i-1].getDepNo());
                        System.out.println("\n   " + j + ". Departman ad : " + ad);

                        System.out.printf("\n     " + i + ". Personel Adi : " + ad1);

                        System.out.printf("\n\n     " + i + ". Personel Soyadi : " + syd);

                        System.out.printf("\n\n     " + i + ". Personel Yasi : ");

                        continue;
                    }
                    break;
                }
                
                departmanlar[i-1].getPersoneller(j-1).Personel(departmanlar[i-1].getDepNo(), ad1, syd, yas);
                
                if(yas>=enb) {
                	enb = yas;
                }
                
                if(yas<=enkc) {
                	enkc = yas;
                }
                
            }
            
            wipeConsole();
            
            System.out.println("\n  Sirket (Proje Ekle) -");
                
            System.out.print("\n    Ka� adet proje eklenecek : ");
                
            while (true) {
                	
            	if(departmanlar[i-1].setInt_projeler(input.nextLine())==0) {
                break;
            	}
                	
                else {
                		
                	wipeConsole();
                    System.out.printf("\n     Eklenecek proje adeti, Int veri tipinde olmali ve 0 dan b�y�k olmali. Tekrar Proje adeti girmek icin Enter'e basiniz. ");
                    input.nextLine();
                        
                    wipeConsole();
                    System.out.println("\n  Sirket (Proje Ekle) -");
                    System.out.print("\n    Ka� adet proje eklenecek : ");
                		
                }

            }
            
        
            departmanlar[i-1].setProjeler();

            for(int k=1; k<departmanlar[i-1].getInt_projeler()+1;k++){
                    	
            	wipeConsole();

                System.out.println("\n  Sirket (Proje Ekle) -");
                System.out.println("\n   " + i + ". Departman no : " + departmanlar[i-1].getDepNo());
                System.out.println("\n   " + i + ". Departman ad : " + ad);

                System.out.printf("\n     " + k + ". proje ad� : ");
                ad = input.nextLine();
                    
                departmanlar[i-1].getProjeler(k-1).proje(i, ad);
                   
            }


        }
        
        
        return departmanlar;
            
        }
    public static void listele(Departman departman, int i) {
    	

        System.out.println("    |����������������|����������������������������������������������������������������������������|");

        String temp;
        String temp0;
        int j = 0, z = 0;

        if(i<0){

            temp = " Departman Ad : " + departman.getDepAd();

            temp0 = "depNo : "+Integer.toString(departman.getDepNo());

        }

        else{

            temp = " Departman No : " + Integer.toString(departman.getDepNo()) + ", Departman Ad : " + departman.getDepAd();
            temp0 = Integer.toString(i + 1) + ". Departman";

        }

        System.out.printf("    | " + temp0);

        for (j = 0; j < 15 - temp0.length(); j++) {
            System.out.printf(" ");
        }

        System.out.printf("|" + temp);

        for (j = 0; j < 76 - temp.length(); j++) {

            System.out.printf(" ");

        }
        System.out.println("|");

        System.out.println("    |________________|____________________________________________________________________________|");

        System.out.println("    |||" + "|����������������|�������������������������������������������������������������������������|");

        for (z = 0; z < departman.getInt_personeller(); z++) {

            if (z != 0) {
                System.out.println("    |||" + "|                |                                                                         |");
            }

            temp0 = Integer.toString(z + 1) + ". Personel";

            System.out.printf("    |||" + "| " + temp0);

            for (j = 0; j < 15 - temp0.length(); j++) {
                System.out.printf(" ");
            }
            
            temp = " perID : " + Integer.toString(departman.getPersoneller(z).getPerID());
            temp += ", perAd-perSoyad : " + departman.getPersoneller(z).getPerAd();
            temp += " " + departman.getPersoneller(z).getPerSoyad();
            temp += ", perYa� : " + Integer.toString(departman.getPersoneller(z).getPerYas());

            System.out.printf("|" + temp);

            for (j = 0; j < 73 - temp.length(); j++) {

                System.out.printf(" ");

            }
            System.out.println("|");

            System.out.println("    |||" + "|________________|_________________________________________________________________________|");

        }

        System.out.println("    |||" + "|����������������|�������������������������������������������������������������������������|");

        for (z = 0; z < departman.getInt_projeler(); z++) {

            if (z != 0) {
                System.out.println("    |||" + "|                |                                                                         |");
            }

            temp0 = Integer.toString(z + 1) + ". Proje";

            System.out.printf("    |||" + "| " + temp0);

            for (j = 0; j < 15 - temp0.length(); j++) {
                System.out.printf(" ");
            }

            temp = " projeID : " + Integer.toString(departman.getProjeler(z).getProjeID());
            temp += ", projeAd : " + departman.getProjeler(z).getProjeAd();

            System.out.printf("|" + temp);

            for (j = 0; j < 73 - temp.length(); j++) {

                System.out.printf(" ");

            }
            System.out.println("|");

            System.out.println("    |||" + "|________________|_________________________________________________________________________|");

        }

    }
    
    

    public static void pr_listele(Personel personel, Departman departman) {
    	


        System.out.println("    |����������������|����������������������������������������������������������������������������|");
        String temp = " Departman Ad : " + departman.getDepAd();
        int j = 0;

        String temp0 = "depNo : "+Integer.toString(departman.getDepNo());

        System.out.printf("    | " + temp0);

        for (j = 0; j < 15 - temp0.length(); j++) {
            System.out.printf(" ");
        }

        System.out.printf("|" + temp);

        for (j = 0; j < 76 - temp.length(); j++) {

            System.out.printf(" ");

        }
        System.out.println("|");

        System.out.println("    |________________|____________________________________________________________________________|");

        System.out.println("    |||" + "|����������������|�������������������������������������������������������������������������|");

        temp0 = "perID : "+Integer.toString(personel.getPerID());

        System.out.printf("    |||" + "| " + temp0);

        for (j = 0; j < 15 - temp0.length(); j++) {
            System.out.printf(" ");
        }

        temp = " perAd-perSoyad : " + personel.getPerAd();
        temp += " " + personel.getPerSoyad();
        temp += ", perYa� : " + Integer.toString(personel.getPerYas());

        System.out.printf("|" + temp);

        for (j = 0; j < 73 - temp.length(); j++) {

            System.out.printf(" ");

        }
        System.out.println("|");

        System.out.println("    |||" + "|________________|_________________________________________________________________________|");

        System.out.println("\n");

    }
    

    public static void proje_listele(Proje proje, Departman departman) {
    	

    	System.out.println("    |����������������|����������������������������������������������������������������������������|");
        String temp = " Departman Ad : " + departman.getDepAd();
        int j = 0;

        String temp0 = "depNo : "+Integer.toString(departman.getDepNo());

        System.out.printf("    | " + temp0);

        for (j = 0; j < 15 - temp0.length(); j++) {
            System.out.printf(" ");
        }

        System.out.printf("|" + temp);

        for (j = 0; j < 76 - temp.length(); j++) {

            System.out.printf(" ");

        }
        System.out.println("|");

        System.out.println("    |________________|____________________________________________________________________________|");

        System.out.println("    |||" + "|����������������|�������������������������������������������������������������������������|");

        temp0 = "projeID : "+Integer.toString(proje.getProjeID());

        System.out.printf("    |||" + "| " + temp0);

        for (j = 0; j < 15 - temp0.length(); j++) {
            System.out.printf(" ");
        }

        temp = " proje ad� : " + proje.getProjeAd();

        System.out.printf("|" + temp);

        for (j = 0; j < 73 - temp.length(); j++) {

            System.out.printf(" ");

        }
        System.out.println("|");

        System.out.println("    |||" + "|________________|_________________________________________________________________________|");

        System.out.println("\n");
    	
    }
    
    

    public static void istatistik_yazdir(Personel personel, Departman departman, int knt) {
    	
  
    	
    	System.out.println("    |����������������|����������������������������������������������������������������������������|");
        String temp = " Departman Ad : " + departman.getDepAd();
        int j = 0;

        String temp0 = "depNo : "+Integer.toString(departman.getDepNo());

        System.out.printf("    | " + temp0);

        for (j = 0; j < 15 - temp0.length(); j++) {
            System.out.printf(" ");
        }

        System.out.printf("|" + temp);

        for (j = 0; j < 76 - temp.length(); j++) {

            System.out.printf(" ");

        }
        System.out.println("|");

        System.out.println("    |________________|____________________________________________________________________________|");
    	
        System.out.println("    |||" + "|����������������|�������������������������������������������������������������������������|");
        
        if(knt==0) {
        	temp0 = "En buyuk";
        }
        
        else {
        	temp0 = "En kucuk";
        }


        System.out.printf("    |||" + "| " + temp0);

        for (j = 0; j < 15 - temp0.length(); j++) {
            System.out.printf(" ");
        }

        temp = " perID : " + Integer.toString(personel.getPerID());
        temp += ", perAd-perSoyad : " + personel.getPerAd();
        temp += " " + personel.getPerSoyad();
        temp += ", perYa� : " + Integer.toString(personel.getPerYas());

        System.out.printf("|" + temp);

        for (j = 0; j < 73 - temp.length(); j++) {

            System.out.printf(" ");

        }
        
        System.out.println("|");
        System.out.println("    |||" + "|________________|_________________________________________________________________________|");
        
        System.out.println("\n");
        
    }
    
 
    public static void wipeConsole() throws AWTException{
    	
    	
    	if(clear==0) {
    		
    		Robot robbie = new Robot();
            
            //clears the console
            robbie.keyPress(KeyEvent.VK_SHIFT);
            robbie.keyPress(KeyEvent.VK_F10);
            robbie.keyRelease(KeyEvent.VK_SHIFT);
            robbie.keyRelease(KeyEvent.VK_F10);
            robbie.keyPress(KeyEvent.VK_R);
            robbie.keyRelease(KeyEvent.VK_R);
            
            if(Departman.getDepSayi()==0) {
            	robbie.keyPress(KeyEvent.VK_ESCAPE);
                robbie.keyRelease(KeyEvent.VK_ESCAPE);
            }
            
            try {
        	    Thread.sleep(1 * 500);
        	} catch (InterruptedException ie) {
        	    Thread.currentThread().interrupt();
        	}
    		
    	}
    	
    	
    	else {
    		
    		for(int i=0;i<30;i++) {
    			System.out.println(" ");
    		}
    		
    	}
    	
    }

}
