package at.incrustwetrust.pizzeria.entity;

import java.util.List;
import java.util.Map;

import static at.incrustwetrust.pizzeria.entity.SubCategory.*;

public enum MainCategory {
    VORSPEISEN,
    HAUPTSPEISEN,
    NACHSPEISEN,
    GETRAENKE;



    private static final Map<MainCategory , List<SubCategory>> validSubCategories = Map.of(
            MainCategory.VORSPEISEN, List.of(),
            MainCategory.HAUPTSPEISEN, List.of(PIZZA,PASTA,BOWL),
            MainCategory.NACHSPEISEN, List.of(),
            MainCategory.GETRAENKE, List.of(ALKOHLFREI, BIER, WEIN)
    );

    public static List<SubCategory> getValidSubCategories(MainCategory mainCat) {
        return validSubCategories.getOrDefault(mainCat, List.of());
    }

    public static boolean isValidSubCategories(MainCategory mainCat, SubCategory subCat) {
        return validSubCategories.getOrDefault(mainCat, List.of()).contains(subCat);
    }

}
