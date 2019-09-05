package happyapp.main;

public class HappyTracker {
    private boolean happy;
    private String happyText = "You are happy!";
    private String happyButtonText = "Click here to be angry!";
    private String angryText = "You are not happy!";
    private String angryButtonText = "Click here to be happy!";

    private String currentText;
    private String currentButtonText;

    public HappyTracker(){
        this.happy = false;
        this.currentText = angryText;
        this.currentButtonText = angryButtonText;
    }

    public boolean isHappy()
    {
        return this.happy;
    }

    public void changeStatus(){
        if(this.happy)
        {
            this.happy = false;
            this.currentButtonText = this.angryButtonText;
            this.currentText = this.angryText;
        }
        else
        {
            this.happy = true;
            this.currentButtonText = this.happyButtonText;
            this.currentText = this.happyText;
        }
    }

    public String getCurrentText()
    {
        return currentText;
    }

    public String getCurrentButtonText()
    {
        return currentButtonText;
    }
}
