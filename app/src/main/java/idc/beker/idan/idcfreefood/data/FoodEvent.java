package idc.beker.idan.idcfreefood.data;

/**
 * Created by User on 12/09/2015.
 */
public class FoodEvent {
    private int eventId;
    private String userDesc;


    public FoodEvent(int eventId, String userDesc) {
        this.eventId = eventId;
        this.userDesc = userDesc;

    }

    private int getImgId(int eventId) {
        return 0;
    }

    public int getEventId() {
        return eventId;
    }

    public String getUserDesc() {
        return userDesc;
    }


    @Override
    public String toString() {
        return userDesc;
    }
}
