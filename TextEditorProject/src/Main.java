import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    static SnapshotEditor snapshotEditor =
            new SnapshotEditor("");

    static CommandEditor commandEditor =
            new CommandEditor("");

    static int actionId = 1;

    public static void main(String[] args) {

        System.out.println("=================================");
        System.out.println("       TEXT EDITOR PROJECT       ");
        System.out.println("=================================");

        System.out.print("Enter initial text: ");

        String initialText = scanner.nextLine();

        snapshotEditor =
                new SnapshotEditor(initialText);

        commandEditor =
                new CommandEditor(initialText);

        while (true) {

            showMenu();

            int choice =
                    readInt("เลือกเมนู: ");

            switch (choice) {

                case 1:
                    insert();
                    break;

                case 2:
                    delete();
                    break;

                case 3:
                    replace();
                    break;

                case 4:
                    undo();
                    break;

                case 5:
                    redo();
                    break;

                case 6:
                    showDocument();
                    break;

                case 7:
                    showStatus();
                    break;

                case 8:
                    runTestCases();
                    break;

                case 9:
                    benchmark();
                    break;

                case 0:

                    System.out.println(
                            "จบการทำงาน"
                    );

                    return;

                default:

                    System.out.println(
                            "กรุณาเลือกเมนู 0-9"
                    );
            }
        }
    }

    
    // MENU
    
    static void showMenu() {

        System.out.println("\n========== MENU ==========");

        System.out.println("1. INSERT");
        System.out.println("2. DELETE");
        System.out.println("3. REPLACE");
        System.out.println("4. UNDO");
        System.out.println("5. REDO");
        System.out.println("6. SHOW DOCUMENT");
        System.out.println("7. SHOW STATUS");
        System.out.println("8. RUN TEST CASES");
        System.out.println("9. BENCHMARK");
        System.out.println("0. EXIT");
    }

    // INSERT
    
    static void insert() {

        int position =
                readInt("Position: ");

        System.out.print("Text: ");

        String text =
                scanner.nextLine();

        long startA =
                System.nanoTime();

        boolean resultA =
                snapshotEditor.insert(
                        position,
                        text
                );

        long endA =
                System.nanoTime();

        long startB =
                System.nanoTime();

        boolean resultB =
                commandEditor.insert(
                        actionId++,
                        position,
                        text
                );

        long endB =
                System.nanoTime();

        if (resultA && resultB) {

            System.out.println(
                    "INSERT สำเร็จ"
            );

            System.out.println(
                    "Snapshot Time: "
                            + (endA - startA)
                            + " ns"
            );

            System.out.println(
                    "Command Time: "
                            + (endB - startB)
                            + " ns"
            );

        } else {

            System.out.println(
                    "ตำแหน่งไม่ถูกต้อง"
            );
        }
    }

    
    // DELETE
    
    static void delete() {

        int position =
                readInt("Position: ");

        int length =
                readInt("Length: ");

        long startA =
                System.nanoTime();

        boolean resultA =
                snapshotEditor.delete(
                        position,
                        length
                );

        long endA =
                System.nanoTime();

        long startB =
                System.nanoTime();

        boolean resultB =
                commandEditor.delete(
                        actionId++,
                        position,
                        length
                );

        long endB =
                System.nanoTime();

        if (resultA && resultB) {

            System.out.println(
                    "DELETE สำเร็จ"
            );

            System.out.println(
                    "Snapshot Time: "
                            + (endA - startA)
                            + " ns"
            );

            System.out.println(
                    "Command Time: "
                            + (endB - startB)
                            + " ns"
            );

        } else {

            System.out.println(
                    "ตำแหน่งหรือความยาวไม่ถูกต้อง"
            );
        }
    }

    
    // REPLACE
    
    static void replace() {

        int position =
                readInt("Position: ");

        int length =
                readInt("Length: ");

        System.out.print(
                "New Text: "
        );

        String newText =
                scanner.nextLine();

        long startA =
                System.nanoTime();

        boolean resultA =
                snapshotEditor.replace(
                        position,
                        length,
                        newText
                );

        long endA =
                System.nanoTime();

        long startB =
                System.nanoTime();

        boolean resultB =
                commandEditor.replace(
                        actionId++,
                        position,
                        length,
                        newText
                );

        long endB =
                System.nanoTime();

        if (resultA && resultB) {

            System.out.println(
                    "REPLACE สำเร็จ"
            );

            System.out.println(
                    "Snapshot Time: "
                            + (endA - startA)
                            + " ns"
            );

            System.out.println(
                    "Command Time: "
                            + (endB - startB)
                            + " ns"
            );

        } else {

            System.out.println(
                    "ตำแหน่งหรือความยาวไม่ถูกต้อง"
            );
        }
    }

   
    // UNDO
    
    static void undo() {

        long startA =
                System.nanoTime();

        boolean resultA =
                snapshotEditor.undo();

        long endA =
                System.nanoTime();

        long startB =
                System.nanoTime();

        boolean resultB =
                commandEditor.undo();

        long endB =
                System.nanoTime();

        if (resultA && resultB) {

            System.out.println(
                    "UNDO สำเร็จ"
            );

            System.out.println(
                    "Snapshot Time: "
                            + (endA - startA)
                            + " ns"
            );

            System.out.println(
                    "Command Time: "
                            + (endB - startB)
                            + " ns"
            );

        } else {

            System.out.println(
                    "ไม่มี Action ให้ Undo"
            );
        }
    }

    // REDO
    
    static void redo() {

        long startA =
                System.nanoTime();

        boolean resultA =
                snapshotEditor.redo();

        long endA =
                System.nanoTime();

        long startB =
                System.nanoTime();

        boolean resultB =
                commandEditor.redo();

        long endB =
                System.nanoTime();

        if (resultA && resultB) {

            System.out.println(
                    "REDO สำเร็จ"
            );

            System.out.println(
                    "Snapshot Time: "
                            + (endA - startA)
                            + " ns"
            );

            System.out.println(
                    "Command Time: "
                            + (endB - startB)
                            + " ns"
            );

        } else {

            System.out.println(
                    "ไม่มี Action ให้ Redo"
            );
        }
    }

   
    // SHOW DOCUMENT
    
    static void showDocument() {

        System.out.println(
                "\nSnapshot Document:"
        );

        System.out.println(
                snapshotEditor.getDocument()
        );

        System.out.println(
                "\nCommand Document:"
        );

        System.out.println(
                commandEditor.getDocument()
        );
    }

    // SHOW STATUS

    static void showStatus() {

        snapshotEditor.showStatus();

        commandEditor.showStatus();
    }

    
    // TEST CASES
    static void runTestCases() {

        System.out.println(
                "\n=============================="
        );

        System.out.println(
                "       TEST CASES"
        );

        System.out.println(
                "=============================="
        );

        testInsertUndo();

        testDeleteUndo();

        testReplaceUndo();

        testUndoRedo();

        testMultipleUndo();

        testUndoNewAction();

        testInvalidPosition();

        testEmptyText();
    }

    
    // TEST 1
    
    static void testInsertUndo() {

        SnapshotEditor s =
                new SnapshotEditor("HelloWorld");

        CommandEditor c =
                new CommandEditor("HelloWorld");

        s.insert(5, "AI");

        c.insert(
                1,
                5,
                "AI"
        );

        s.undo();

        c.undo();

        boolean pass =
                s.getDocument()
                        .equals("HelloWorld")
                        &&
                c.getDocument()
                        .equals("HelloWorld");

        printTest(
                "1. Insert แล้ว Undo",
                pass
        );
    }

    
    // TEST 2
    
    static void testDeleteUndo() {

        SnapshotEditor s =
                new SnapshotEditor("HelloWorld");

        CommandEditor c =
                new CommandEditor("HelloWorld");

        s.delete(5, 5);

        c.delete(
                1,
                5,
                5
        );

        s.undo();

        c.undo();

        boolean pass =
                s.getDocument()
                        .equals("HelloWorld")
                        &&
                c.getDocument()
                        .equals("HelloWorld");

        printTest(
                "2. Delete แล้ว Undo",
                pass
        );
    }

    
    // TEST 3
   
    static void testReplaceUndo() {

        SnapshotEditor s =
                new SnapshotEditor("HelloWorld");

        CommandEditor c =
                new CommandEditor("HelloWorld");

        s.replace(
                5,
                5,
                "AI"
        );

        c.replace(
                1,
                5,
                5,
                "AI"
        );

        s.undo();

        c.undo();

        boolean pass =
                s.getDocument()
                        .equals("HelloWorld")
                        &&
                c.getDocument()
                        .equals("HelloWorld");

        printTest(
                "3. Replace แล้ว Undo",
                pass
        );
    }

    
    // TEST 4
    
    static void testUndoRedo() {

        SnapshotEditor s =
                new SnapshotEditor("Hello");

        CommandEditor c =
                new CommandEditor("Hello");

        s.insert(5, " AI");

        c.insert(
                1,
                5,
                " AI"
        );

        s.undo();
        c.undo();

        s.redo();
        c.redo();

        boolean pass =
                s.getDocument()
                        .equals("Hello AI")
                        &&
                c.getDocument()
                        .equals("Hello AI");

        printTest(
                "4. Undo แล้ว Redo",
                pass
        );
    }

    
    // TEST 5
    
    static void testMultipleUndo() {

        SnapshotEditor s =
                new SnapshotEditor("A");

        CommandEditor c =
                new CommandEditor("A");

        s.insert(1, "B");
        c.insert(1, 1, "B");

        s.insert(2, "C");
        c.insert(2, 2, "C");

        s.undo();
        c.undo();

        s.undo();
        c.undo();

        boolean pass =
                s.getDocument()
                        .equals("A")
                        &&
                c.getDocument()
                        .equals("A");

        printTest(
                "5. Undo หลายครั้ง",
                pass
        );
    }

    
    // TEST 6
   
    static void testUndoNewAction() {

        SnapshotEditor s =
                new SnapshotEditor("ABC");

        CommandEditor c =
                new CommandEditor("ABC");

        s.insert(3, "D");
        c.insert(1, 3, "D");

        s.undo();
        c.undo();

        s.insert(3, "X");
        c.insert(2, 3, "X");

        boolean pass =
                s.getRedoSize() == 0
                        &&
                c.getRedoSize() == 0;

        printTest(
                "6. Undo แล้วทำ Action ใหม่",
                pass
        );
    }

   
    // TEST 7
   
    static void testInvalidPosition() {

        SnapshotEditor s =
                new SnapshotEditor("ABC");

        CommandEditor c =
                new CommandEditor("ABC");

        boolean resultS =
                s.insert(100, "X");

        boolean resultC =
                c.insert(
                        1,
                        100,
                        "X"
                );

        boolean pass =
                !resultS && !resultC;

        printTest(
                "7. ตำแหน่งข้อความไม่ถูกต้อง",
                pass
        );
    }

    
    // TEST 8
    
    static void testEmptyText() {

        SnapshotEditor s =
                new SnapshotEditor("");

        CommandEditor c =
                new CommandEditor("");

        boolean resultS =
                s.insert(0, "A");

        boolean resultC =
                c.insert(
                        1,
                        0,
                        "A"
                );

        boolean pass =
                resultS
                        &&
                resultC
                        &&
                s.getDocument().equals("A")
                        &&
                c.getDocument().equals("A");

        printTest(
                "8. ข้อความว่าง",
                pass
        );
    }

    
    // PRINT TEST
    
    static void printTest(
            String name,
            boolean pass
    ) {

        System.out.println(
                name
                        + " : "
                        + (pass
                        ? "PASS"
                        : "FAIL")
        );
    }

    
    // BENCHMARK
    
    static void benchmark() {

        System.out.println(
                "\n=============================="
        );

        System.out.println(
                "       BENCHMARK"
        );

        System.out.println(
                "=============================="
        );

        int[] textSizes = {
                100,
                1000,
                10000,
                100000
        };

        int[] actionCounts = {
                100,
                1000,
                10000
        };

        for (int textSize : textSizes) {

            for (int actionCount : actionCounts) {

                runBenchmark(
                        textSize,
                        actionCount
                );
            }
        }
    }

    
    // RUN BENCHMARK
    
    static void runBenchmark(
            int textSize,
            int actionCount
    ) {

        long snapshotUndoTotal = 0;
        long commandUndoTotal = 0;

        long snapshotRedoTotal = 0;
        long commandRedoTotal = 0;

        int rounds = 5;

        for (int r = 0; r < rounds; r++) {

            String text =
                    "A".repeat(textSize);

            SnapshotEditor snapshot =
                    new SnapshotEditor(text);

            CommandEditor command =
                    new CommandEditor(text);

            // Create actions
            for (int i = 0;
                 i < actionCount;
                 i++) {

                int position =
                        Math.min(
                                i % (textSize + 1),
                                snapshot.getDocument().length()
                        );

                snapshot.insert(
                        position,
                        "X"
                );

                command.insert(
                        i + 1,
                        position,
                        "X"
                );
            }

            // Undo timing
            long startSnapshot =
                    System.nanoTime();

            snapshot.undo();

            long endSnapshot =
                    System.nanoTime();

            snapshotUndoTotal +=
                    endSnapshot
                            - startSnapshot;

            long startCommand =
                    System.nanoTime();

            command.undo();

            long endCommand =
                    System.nanoTime();

            commandUndoTotal +=
                    endCommand
                            - startCommand;

            // Redo timing
            long startSnapshotRedo =
                    System.nanoTime();

            snapshot.redo();

            long endSnapshotRedo =
                    System.nanoTime();

            snapshotRedoTotal +=
                    endSnapshotRedo
                            - startSnapshotRedo;

            long startCommandRedo =
                    System.nanoTime();

            command.redo();

            long endCommandRedo =
                    System.nanoTime();

            commandRedoTotal +=
                    endCommandRedo
                            - startCommandRedo;
        }

        System.out.println(
                "\nText Size = "
                        + textSize
        );

        System.out.println(
                "Actions = "
                        + actionCount
        );

        System.out.println(
                "Snapshot Undo Avg = "
                        + snapshotUndoTotal / rounds
                        + " ns"
        );

        System.out.println(
                "Command Undo Avg = "
                        + commandUndoTotal / rounds
                        + " ns"
        );

        System.out.println(
                "Snapshot Redo Avg = "
                        + snapshotRedoTotal / rounds
                        + " ns"
        );

        System.out.println(
                "Command Redo Avg = "
                        + commandRedoTotal / rounds
                        + " ns"
        );
    }

    // INPUT VALIDATION
   
    static int readInt(String message) {

        while (true) {

            try {

                System.out.print(message);

                return Integer.parseInt(
                        scanner.nextLine()
                );

            } catch (NumberFormatException e) {

                System.out.println(
                        "กรุณาป้อนตัวเลขเท่านั้น"
                );
            }
        }
    }
}