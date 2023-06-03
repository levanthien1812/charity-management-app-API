package dev.asheep.charitymanagementapp.models;
import java.util.List;
public class DistributionList {
    private int category_id;
    private int event_id;
    private int receiver_id;

    private int transfer_id;

    private String status;

    private List<ItemTo> itemList;

    public DistributionList() {
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public int getEvent_id() {
        return event_id;
    }

    public void setEvent_id(int event_id) {
        this.event_id = event_id;
    }

    public int getReceiver_id() {
        return receiver_id;
    }

    public void setReceiver_id(int receiver_id) {
        this.receiver_id = receiver_id;
    }

    public int getTransfer_id() {
        return transfer_id;
    }

    public void setTransfer_id(int transfer_id) {
        this.transfer_id = transfer_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ItemTo> getItemList() {
        return itemList;
    }

    public void setItemList(List<ItemTo> itemList) {
        this.itemList = itemList;
    }
}
