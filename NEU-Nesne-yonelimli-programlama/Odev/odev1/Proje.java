
public class Proje {


	private static int projeID0 = 0;
	private int depNo;
	private int projeID;
	private String projeAd;
    private int projeSure;
    private int projeMaliyet;
    

    public void proje(int depNo, String projeAd){

        this.setDepNo(depNo);
        this.setProjeID(this.getProjeID0()); 
        this.setProjeAd(projeAd);
        this.setProjeSure(projeSure);
        this.setProjeMaliyet(projeMaliyet);         
    }
    

    
    public int getDepNo() {

        return depNo;
    }
    public void setDepNo(int depNo) {

        this.depNo = depNo;
    }
    public int getProjeID0() {

        return projeID0;
    }
    public void setProjeID0() {
        projeID0 += 1;
    }
    public int getProjeID() {

        return projeID;
    }
    public void setProjeID(int projeID) {
        this.projeID = projeID;
    }
    public String getProjeAd() {

        return projeAd;
    }

    public void setProjeAd(String projeAd) {

        this.projeAd = projeAd;
    }
    public int getProjeSure() {

        return projeSure;
    }
    public void setProjeSure(int projeSure) {

        this.projeSure = projeSure;
    }
    public int getProjeMaliyet() {

        return projeMaliyet;
    }
    public void setProjeMaliyet(int projeMaliyet) {

        this.projeMaliyet = projeMaliyet;
    }
    
    
}
