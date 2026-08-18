import java.time.LocalDateTime;

public class Action {

    public enum ActionType {
        INSERT,
        DELETE,
        REPLACE
    }

    private final int actionId;
    private final ActionType actionType;
    private final int position;
    private final String oldText;
    private final String newText;
    private final LocalDateTime timestamp;

    public Action(
            int actionId,
            ActionType actionType,
            int position,
            String oldText,
            String newText
    ) {
        this.actionId = actionId;
        this.actionType = actionType;
        this.position = position;
        this.oldText = oldText;
        this.newText = newText;
        this.timestamp = LocalDateTime.now();
    }

    public int getActionId() {
        return actionId;
    }

    public ActionType getActionType() {
        return actionType;
    }

    public int getPosition() {
        return position;
    }

    public String getOldText() {
        return oldText;
    }

    public String getNewText() {
        return newText;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return "Action{" +
                "ID=" + actionId +
                ", Type=" + actionType +
                ", Position=" + position +
                ", OldText='" + oldText + '\'' +
                ", NewText='" + newText + '\'' +
                ", Timestamp=" + timestamp +
                '}';
    }
}