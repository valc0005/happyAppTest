package happyapp.main;

import android.widget.ImageView;

public class HappyTracker {
    private boolean happy;
    private String happyText = "You rolled a 6! You are happy!";
    private String angryText = "You are not happy! Roll a 6 to be happy!";

    private String currentText;
    private String currentButtonText;

    public HappyTracker(){
        this.happy = false;
        this.currentText = angryText;
    }

    public boolean isHappy()
    {
        return this.happy;
    }

    public void changeStatus(ImageView image){
        if(this.happy)
        {
            this.happy = false;
            this.currentText = this.angryText;
            image.setImageResource(R.drawable.angry);
        }
        else
        {
            this.happy = true;
            this.currentText = this.happyText;
            image.setImageResource(R.drawable.grin);
        }
    }

    public String getCurrentText()
    {
        return currentText;
    }

}
