package ui;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;

import data.RecipeFileHandler;

public class RecipeUI {
    private BufferedReader reader;
    private RecipeFileHandler fileHandler;

    public RecipeUI() {
        reader = new BufferedReader(new InputStreamReader(System.in));
        fileHandler = new RecipeFileHandler();
    }

    public RecipeUI(BufferedReader reader, RecipeFileHandler fileHandler) {
        this.reader = reader;
        this.fileHandler = fileHandler;
    }

    public void displayMenu() {
        while (true) {
            try {
                System.out.println();
                System.out.println("Main Menu:");
                System.out.println("1: Display Recipes");
                System.out.println("2: Add New Recipe");
                System.out.println("3: Search Recipe");
                System.out.println("4: Exit Application");
                System.out.print("Please choose an option: ");

                String choice = reader.readLine();

                switch (choice) {
                    case "1":
                        // 設問1: 一覧表示機能
                        displayRecipes();
                        break;
                    case "2":
                        // 設問2: 新規登録機能
                        addNewRecipe();
                        break;
                    case "3":
                        // 設問3: 検索機能
                        break;
                    case "4":
                        System.out.println("Exit the application.");
                        return;
                    default:
                        System.out.println("Invalid choice. Please select again.");
                        break;
                }
            } catch (IOException e) {
                System.out.println("Error reading input from user: " + e.getMessage());
            }
        }
    }

    /**
     * 設問1: 一覧表示機能
     * RecipeFileHandlerから読み込んだレシピデータを整形してコンソールに表示します。
     */
    private void displayRecipes() {
        ArrayList<String> list = new ArrayList<>();//リストをStringに変換
        list = fileHandler.readRecipes();
        System.out.println("recipes:");//料理の表示
        // 各表示をリスト分ループさせる処理
        for (int i = 0; i <= list.size(); i++) {
            String[] list2 = list.get(i).split(",");
            //区切りの表示
            System.out.println("-----------------------------------");
            //料理名の処理
            System.out.println(" Recipe Name: " + list2[0]);
            //材料名の処理
            System.out.print("Main Ingredients: ");
            for (int k = 0; k <= list2.length - 1; k++) {
                System.out.print(list2[k]);
                //料理名に区切りをつける
                if(k<list2.length-1){
                    System.out.print(",");
                }
                // 表示を調整するための改行
            }
            System.out.println();
        }
        // Recipes:
        // -----------------------------------
        // Recipe Name: Tomato Soup
        // Main Ingredients: Tomatoes, Onion, Garlic, Vegetable Stock
        // -----------------------------------
        // Recipe Name: Chicken Curry
        // Main Ingredients: Chicken, Curry Powder, Onion, Garlic, Ginger
        // -----------------------------------
        // Recipe Name: Beef Stew
        // Main Ingredients: Beef, Potatoes, Carrots, Onion, Beef Stock
        // -----------------------------------

    }

    /**
     * 設問2: 新規登録機能
     * ユーザーからレシピ名と主な材料を入力させ、RecipeFileHandlerを使用してrecipes.txtに新しいレシピを追加します。
     *
     * @throws java.io.IOException 入出力が受け付けられない
     */
    //RecipeFileHandlerを使用してrecipes.txtに新しいレシピを追加します。
    private void addNewRecipe() throws IOException {
         //ユーザーからレシピ名と主な材料を入力させる
    System.out.println("Enter recipe name: ");
    String recipeName=reader.readLine();
    System.out.println("Enter main ingredients (comma separated): ");
    String ingredients=reader.readLine();
    // addRecipeに入力値を送る
    fileHandler.addRecipe(recipeName, ingredients);
}

    /**
     * 設問3: 検索機能
     * ユーザーから検索クエリを入力させ、そのクエリに基づいてレシピを検索し、一致するレシピをコンソールに表示します。
     *
     * @throws java.io.IOException 入出力が受け付けられない
     */
    private void searchRecipe() throws IOException {
        
    }

}
