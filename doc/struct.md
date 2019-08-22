## Структура

```
val moduleName = "имя модуля"
- $moduleName
    - api
        - "${moduleName}ComponentProvider" // зависимости которые модуль может предоставить
    - data
    - di
        - "${moduleName}Component" // внутренние зависимости
    - domain
    - ui
    
```