package data;

import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;

public class RecipeFileHandler {
    private String filePath;

    public RecipeFileHandler() {
        filePath = "app/src/main/resources/recipes.txt";
    }

    public RecipeFileHandler(String filePath) {
        this.filePath = filePath;
    }

    /**
     * 設問1: 一覧表示機能
     * recipes.txtからレシピデータを読み込み、それをリスト形式で返します。 <br>
     * IOExceptionが発生したときは<i>Error reading file: 例外のメッセージ</i>とコンソールに表示します。
     *
     * @return レシピデータ
     */
    public ArrayList<String> readRecipes() {
        ArrayList<String> recipes = new ArrayList<>();//Stringに変換
        // try {
            // recipes.txtからレシピデータを読み込み
            try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                String line;
                //、それをリスト形式でループさせて返します。
                while ((line = reader.readLine()) != null) {
                    recipes.add(line);
                    // } catch (IOException e) {
                        // System.out.println("Error reading file:" + e.getMessage());
                        // }
                    }
                    // IOExceptionが発生したときはError reading file: 例外のメッセージとコンソールに表示します。
                } catch (IOException e) {
            System.out.println("Error reading file" + e.getMessage());
        }
        return recipes;
    }
    /**
     * 設問2: 新規登録機能
     * 新しいレシピをrecipes.txtに追加します。<br>
     * レシピ名と材料はカンマ区切りで1行としてファイルに書き込まれます。
     *
     * @param recipeName  レシピ名
     * @param ingredients 材料名
     */
    public void addRecipe(String recipeName, String ingredients) {
        // try
        
        // 新しいレシピをrecipes.txtに追加する。
        try(BufferedWriter writer=new BufferedWriter(new FileWriter(filePath,true))){
            // レシピ名と材料はカンマ区切りで1行としてファイルに書き込まれる。
            writer.write(recipeName+","+ingredients);
            writer.newLine();
            // 入力の成功を表示する
            System.out.println("Recipe added successfuly");
            // IOExceptionが発生したときはError reading file: 例外のメッセージとコンソールに表示する。
    }catch(IOException e){
        System.out.println("Error reading file: 例外のメッセージ"+e.getMessage());
    }

    }

}


