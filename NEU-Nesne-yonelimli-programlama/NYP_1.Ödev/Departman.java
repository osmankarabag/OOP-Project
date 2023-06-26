public class Departman {
	
    private int depNo;
    private String depAd;
    
    private Personel[] personeller;
        
    private Proje[] projeler;
       
    private int int_personeller=0;
    private int int_projeler=0;
       
    private static int depSayi = 0;
        
    public void Departman(int depNo, String depAd){
    	
        this.setDepNo(Integer.toString(depNo));
        this.setDepAd(depAd);

    }
      

    public void setDepAd(String depAd){

        this.depAd = depAd;
        depNo += 1;
        setDepSayi();

    }
    public String getDepAd(){

        return depAd;
    }

    public int setDepNo(String depNo){
    	
    	int kn=0;
    	int no=0;
    	try {

            no = Integer.parseInt(depNo);
        } catch (NumberFormatException ex) {
        	kn = 1;
        }
    	
    	if(kn==0) {
    		
    		this.depNo=no;
    		
    	}
    	
    	return kn;
    }

    public int getDepNo(){

        return depNo;
    }

    public void setPersoneller(){

        personeller = new Personel[getInt_personeller()];
        
        for(int i=0; i<getInt_personeller(); i++) {
        	personeller[i] = new Personel();
        }
    }

    public Personel getPersoneller(int index){

        return personeller[index];
    }

    public void setProjeler(){

        projeler = new Proje[getInt_projeler()];
        
        for(int i=0; i<getInt_projeler(); i++) {
        	projeler[i] = new Proje();
        }
    }

    public Proje getProjeler(int index){

        return projeler[index];
    }

    public int getInt_personeller() {

        return int_personeller;
    }

    public int setInt_personeller(String adet) {
    	
    	int kn=0;
    	int pr_adet = 0;

    	try {

            pr_adet = Integer.parseInt(adet);
        } catch (NumberFormatException ex) {
        	
        	kn=1;

        }
    	
    	if(pr_adet<0) {
    		kn=1;
    	}
    	
    	if(kn==0) {
    		int_personeller = pr_adet;
    	}
    	
    	return kn;
    }

    public int getInt_projeler() {

        return int_projeler;
    }

    public int setInt_projeler(String adet) {

    	int kn=0;
    	int proje_adet = 0;

    	try {

            proje_adet = Integer.parseInt(adet);
        } catch (NumberFormatException ex) {
        	
        	kn=1;

        }
    	
    	if(proje_adet<0) {
    		kn=1;
    	}
    	
    	if(kn==0) {
    		int_projeler = proje_adet;
    	}
    	
    	return kn;
    }

    public static int getDepSayi() {

        return depSayi;
    }

    public static void setDepSayi() {

        depSayi+=1;
    }

}
