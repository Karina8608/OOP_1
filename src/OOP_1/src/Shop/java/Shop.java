package OOP_1.src.Shop.java;

//Регистрация пользователей
        users.put("Света", new User ("Света", "KOSTROMA_MON_AMOUR"));
        users.put("Ваня", new User("Ваня", "BERliner_ist_ein_Donut"));
        users.put("Женя", new User("Женя", "ThereIsNothingInArea51"));
        users.put("Федя", new User("Федя", "HerMajestyShipNotShit"));
        }

void trade(){
    //Показ состояния магазина
    printShop();

    //Торги
    System.out.println("Продано:");
    this.saleProduct("Света", 5, 2);
    this.saleProduct("Ваня", 4, 1);
    this.saleProduct("Женя", 6, 1);
    this.saleProduct("Ваня", 6, 1);
    this.saleProduct("Федя", 7, 7777);
    this.saleProduct("Федя", 13, 100);
    this.saleProduct("Света", 8, 3333);
    System.out.println("______________________________________________________________\n");

    //Показ состояния магазина
    printShop();
}

void printShop() {
    System.out.println("Shop:");
    for (Category category : this.categories) {
        System.out.println(category);
    }
    System.out.println("______________________________________________________________\n");
}

void saleProduct(String userName, int productId, int count) {
    Product product = this.getProduct(productId);
    System.out.print(userName +
            " пробовал купить товар с id = " + productId +
            " в количестве " + count + " штук. "
    );
    if (product == null) {
        System.out.println("Но продукт не существует. Пока что.");
    } else if (product.getCount() < count) {
        System.out.println("Но такого количества '" + product.getName() + "' в магазине нет. Пока что.");
    } else {
        this.users.get(userName).getBasket().putInBasket(productId, count);
        product.saleProduct(count);
        System.out.println("И купил " + count + " '" + product.getName() + "'!");
    }
}

Product getProduct(int productId) {
    for (Category category : this.categories) {
        Product product = category.getProduct(productId);
        if (product != null) {
            return product;
        }
    }
    return null;
}
}
