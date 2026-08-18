import java.util.ArrayDeque;
import java.util.Deque;

public class SnapshotEditor {

    private StringBuilder document;

    private final Deque<String> undoStack;
    private final Deque<String> redoStack;

    private int pushCount;
    private int popCount;
    private int operationCount;

    public SnapshotEditor(String initialText) {
        document = new StringBuilder(initialText);

        undoStack = new ArrayDeque<>();
        redoStack = new ArrayDeque<>();
    }

   
    // INSERT
    
    public boolean insert(int position, String text) {

        if (position < 0 || position > document.length()) {
            return false;
        }

        saveSnapshot();

        document.insert(position, text);

        clearRedo();

        operationCount++;
        return true;
    }

  
    // DELETE
    public boolean delete(int position, int length) {

        if (position < 0 ||
                length < 0 ||
                position + length > document.length()) {
            return false;
        }

        saveSnapshot();

        document.delete(position, position + length);

        clearRedo();

        operationCount++;
        return true;
    }

   
    // REPLACE
   
    public boolean replace(
            int position,
            int length,
            String newText
    ) {

        if (position < 0 ||
                length < 0 ||
                position + length > document.length()) {
            return false;
        }

        saveSnapshot();

        document.replace(
                position,
                position + length,
                newText
        );

        clearRedo();

        operationCount++;
        return true;
    }

   
    // SAVE SNAPSHOT
    
    private void saveSnapshot() {

        undoStack.push(document.toString());
        pushCount++;
    }

    // UNDO
  
    public boolean undo() {

        if (undoStack.isEmpty()) {
            return false;
        }

        redoStack.push(document.toString());
        pushCount++;

        document = new StringBuilder(
                undoStack.pop()
        );

        popCount++;

        operationCount++;

        return true;
    }


    // REDO
    public boolean redo() {

        if (redoStack.isEmpty()) {
            return false;
        }

        undoStack.push(document.toString());
        pushCount++;

        document = new StringBuilder(
                redoStack.pop()
        );

        popCount++;

        operationCount++;

        return true;
    }

    
    // CLEAR REDO
    
    private void clearRedo() {

        redoStack.clear();
    }

    // GET DOCUMENT
   
    public String getDocument() {

        return document.toString();
    }

  
    // STATUS
    public void showStatus() {

        System.out.println("\n----- Snapshot Status -----");

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
                "Total Operations: " + operationCount
        );
    }

    public int getPushCount() {
        return pushCount;
    }

    public int getPopCount() {
        return popCount;
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