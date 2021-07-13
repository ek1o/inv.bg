
    Feature: Item tests
    Background:
      Given :user should be logged in successfully
      And language should be set on "BG"
      Then :user panel should contain text "emil@thenet.bg"

      Scenario: Add new Item with required and optional fields
        When  i click on items button
        Then  items page should be successfully loaded and should contain text "Артикули".
        And Tab items should be selected .
        When i click on new item button.
        Then item add page should be successfully loaded should contain text "Нов артикул".
        When i fill up required information and click add item button
        Then "Артикулът е добавен успешно." Confirmation message should appear.
        When delete created new item "Избраните артикули бяха изтрити успешно." Confirmation message should appear.

        Scenario: Try add new Item with input zero in quantity field
          When  i click on items button
          Then  items page should be successfully loaded and should contain text "Артикули".
          And Tab items should be selected .
          When i click on new item button.
          Then item add page should be successfully loaded should contain text "Нов артикул".
          When i fill up required information with zero value in quantity filed and click add item button
          Then "Моля, въведете количество по - голямо от 0." Error message should appear.

          Scenario Outline: Add multiple new Items with required and optional fields
            When  i click on items button
            Then  items page should be successfully loaded and should contain text "Артикули".
            And Tab items should be selected .
            When i click on new item button.
            Then item add page should be successfully loaded should contain text "Нов артикул".
            When i enter name of item "<itemName>", "<itemNameEng>" ,"<singlePrice>","<dds>","<quantity>"
            Then Confirmation message "<message>" should be visible.
            When delete created new item "<deleteMessage>" Confirmation message should appear.

            Examples:
              | itemName | itemNameEng|singlePrice|dds|quantity|message                                      |deleteMessage|
              | кутия    | box        | 10        |20 | 2      | Артикулът е добавен успешно.                |Избраните артикули бяха изтрити успешно.|
              | пъпещ    | melon      | 15        |20 | 30     | Артикулът е добавен успешно.                |Избраните артикули бяха изтрити успешно.|
              | ябълка   | apple      | 20        | 0 | 50     | Артикулът е добавен успешно.                |Избраните артикули бяха изтрити успешно.|
              | грозде   | grape      | 8         | 0 | 0      | Моля, въведете количество по - голямо от 0. |Моля, въведете количество по - голямо от 0.|





