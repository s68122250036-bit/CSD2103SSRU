import java.util.ArrayDeque;
import java.util.Deque;

public class CommandEditor {

    private StringBuilder document;

    private final Deque<Action> undoStack;
    private final Deque<Action> redoStack;

    private int pushCount;
    private int popCount;
    private int comparisonCount;
    private int operationCount;

    public CommandEditor(String initialText) {

        document = new StringBuilder(initialText);

        undoStack = new ArrayDeque<>();
        redoStack = new ArrayDeque<>();
    }

    // INSERT
  
    public boolean insert(
            int actionId,
            int position,
            String text
    ) {

        if (position < 0 ||
                position > document.length()) {

            return false;
        }

        document.insert(position, text);

        Action action = new Action(
                actionId,
                Action.ActionType.INSERT,
                position,
                "",
                text
        );

        undoStack.push(action);
        pushCount++;

        redoStack.clear();

        operationCount++;

        return true;
    }

    
    // DELETE
    
    public boolean delete(
            int actionId,
            int position,
            int length
    ) {

        if (position < 0 ||
                length < 0 ||
                position + length > document.length()) {

            return false;
        }

        String oldText =
                document.substring(
                        position,
                        position + length
                );

        document.delete(
                position,
                position + length
        );

        Action action = new Action(
                actionId,
                Action.ActionType.DELETE,
                position,
                oldText,
                ""
        );

        undoStack.push(action);
        pushCount++;

        redoStack.clear();

        operationCount++;

        return true;
    }

  
    // REPLACE
    
    public boolean replace(
            int actionId,
            int position,
            int length,
            String newText
    ) {

        if (position < 0 ||
                length < 0 ||
                position + length > document.length()) {

            return false;
        }

        String oldText =
                document.substring(
                        position,
                        position + length
                );

        document.replace(
                position,
                position + length,
                newText
        );

        Action action = new Action(
                actionId,
                Action.ActionType.REPLACE,
                position,
                oldText,
                newText
        );

        undoStack.push(action);
        pushCount++;

        redoStack.clear();

        operationCount++;

        return true;
    }

   
    // UNDO
   
    public boolean undo() {

        if (undoStack.isEmpty()) {
            return false;
        }

        Action action = undoStack.pop();

        popCount++;

        applyInverse(action);

        redoStack.push(action);

        pushCount++;

        operationCount++;

        return true;
    }

    
    // REDO
    
    public boolean redo() {

        if (redoStack.isEmpty()) {
            return false;
        }

        Action action = redoStack.pop();

        popCount++;

        applyForward(action);

        undoStack.push(action);

        pushCount++;

        operationCount++;

        return true;
    }

    
    // INVERSE OPERATION
    
    private void applyInverse(Action action) {

        comparisonCount++;

        switch (action.getActionType()) {

            case INSERT:

                // Undo INSERT
                // ลบข้อความที่เคย Insert

                document.delete(
                        action.getPosition(),
                        action.getPosition()
                                + action.getNewText().length()
                );

                break;

            case DELETE:

                // Undo DELETE
                // ใส่ข้อความเดิมกลับเข้าไป

                document.insert(
                        action.getPosition(),
                        action.getOldText()
                );

                break;

            case REPLACE:

                // Undo REPLACE
                // เปลี่ยนข้อความใหม่กลับเป็นข้อความเดิม

                document.replace(
                        action.getPosition(),
                        action.getPosition()
                                + action.getNewText().length(),
                        action.getOldText()
                );

                break;
        }
    }

    
    // FORWARD OPERATION
    
    private void applyForward(Action action) {

        comparisonCount++;

        switch (action.getActionType()) {

            case INSERT:

                document.insert(
                        action.getPosition(),
                        action.getNewText()
                );

                break;

            case DELETE:

                document.delete(
                        action.getPosition(),
                        action.getPosition()
                                + action.getOldText().length()
                );

                break;

            case REPLACE:

                document.replace(
                        action.getPosition(),
                        action.getPosition()
                                + action.getOldText().length(),
                        action.getNewText()
                );

                break;
        }
    }

    
    // GET DOCUMENT
    
    public String getDocument() {

        return document.toString();
    }

    
    // STATUS
   
    public void showStatus() {

        System.out.println("\n----- Command Status -----");

        System.out.println(
                "Document: " + document
        );

        System.out.println(
                "Undo Stack Size: " + undoStack.size()
        );

        System.out.println(
                "Redo Stack Size: " + redoStack.size()
        );

        System.out.println(
                "Push Operations: " + pushCount
        );

        System.out.println(
                "Pop Operations: " + popCount
        );

        System.out.println(
                "Comparisons: " + comparisonCount
        );

        System.out.println(
                "Total Operations: " + operationCount
        );
    }

    public int getPushCount() {
        return pushCount;
    }

    public int getPopCount() {
        return popCount;
    }

    public int getComparisonCount() {
        return comparisonCount;
    }

    public int getOperationCount() {
        return operationCount;
    }

    public int getUndoSize() {
        return undoStack.size();
    }

    public int getRedoSize() {
        return redoStack.size();
    }
}