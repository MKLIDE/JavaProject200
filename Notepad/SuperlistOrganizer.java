import java.util.*;

public class SuperlistOrganizer {

    static class Category {
        String name;
        TreeSet<String> tasks = new TreeSet<>();

        Category(String name) {
            this.name = capitalize(name);
        }

        void addTasks(String... tasksInput) {
            for (String task : tasksInput) {
                String cleanTask = capitalize(task.trim());
                tasks.add(cleanTask);
            }
        }

        void deleteTask(String task) {
            tasks.remove(capitalize(task.trim()));
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Category: ").append(name).append("\n");
            for (String task : tasks) {
                sb.append(String.format("- %s\n", task));
            }
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Category> categoryMap = new LinkedHashMap<>();

        System.out.println("Welcome to the Dynamic Superlist Organizer!");
        while (true) {
            System.out.print("\nEnter category name (or type 'done'): ");
            String inputCategory = scanner.nextLine().trim();
            if (inputCategory.equalsIgnoreCase("done")) break;

            String categoryKey = capitalize(inputCategory);
            Category category = categoryMap.getOrDefault(categoryKey, new Category(categoryKey));

            System.out.print("Enter tasks (comma-separated): ");
            String[] tasksInput = scanner.nextLine().split(",");

            category.addTasks(tasksInput);
            categoryMap.put(categoryKey, category);

            // Optional deletion
            System.out.print("Would you like to delete any task from this category? (yes/no): ");
            if (scanner.nextLine().trim().equalsIgnoreCase("yes")) {
                while (true) {
                    System.out.println("Current Tasks: " + category.tasks);
                    System.out.print("Enter task to delete (or type 'no' to continue): ");
                    String taskToDelete = scanner.nextLine().trim();
                    if (taskToDelete.equalsIgnoreCase("no")) break;
                    category.deleteTask(taskToDelete);
                }
            }
        }

        // Display all categories and tasks
        System.out.println("\nYour Superlist:");
        for (Category cat : categoryMap.values()) {
            System.out.println(cat);
        }

        scanner.close();
    }

    // Capitalizes the first letter of a word
    private static String capitalize(String word) {
        if (word.isEmpty()) return word;
        return word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();
    }
}
