package enc.test.galarysample;

/**
 * Created by Admin on 29-07-2017.
 */

public class TopRecyclerPojo {
    String id, text;
    String icon;
    public TopRecyclerPojo(String id, String icon) {
        this.id = id;
        this.text = text;
        this.icon = icon;
    }

    public void setId(String id) {

        this.id = id;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getId() {

        return id;
    }

    public String getText() {
        return text;
    }

    public String getIcon() {
        return icon;
    }


}
