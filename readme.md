##Арі тесты для Rest Assured 

###Инфо по проекту
`src/main/java/constants/Constants.java` - класс, в котором хранятся все ссылки и методы апи
`src/main/java/config/TestConfig.java` - класс-родитель тестов, помеченный `@BeforeClass`, который связывает константы с тестами. В нем так же создаются спецификации.

##Lifehacks
- Если хочешь использовать аннотацию `@BeforeClass` из другого класса - сделай класс с тестами дочерним;
- Если хочешь использовать разные `baseURI` и `basePath` для разных тестнаборов, используй `RequestSpecification`,  созданную через `RequestSpecBuilder`: https://stackoverflow.com/questions/30426397/how-to-initialize-multiple-restassured-url-in-the-same-project-without-overridin
- Чтобы сделать некую кастомную спеку базовой (не вызывать её каждый раз в тесте), то можно в `@BeforeCalss` сделать `RestAssured.requestSpecification = customSpec;`\
  В целом, спеки позволяют подготовить набор хедеров, куки и авторизации для отправки в тестах
- В `ResponseSpecification` прописываются время ожидания, боди, хидеры, статускоды и тд. ответа.
- Параметры в GET-запрос добавляются методом `given.queryParam("page", "2")`
- Обратиться к nth элементу объекта можно так: `"корень_массива.поле_эл-та_массива[номер_эл-та]"`. Пример для json:
  `{"page": 2,"data": [{"id": 7 }, {"id": 8 }] }` `"data.id[0]"`
- Валидация по XSD выполняется путем использования метода: `then().
  body(io.restassured.matcher.RestAssuredMatchers.matchesXsdInClasspath("fileName.xsd"))`
- Валидация по JSON Schema выполняется путем использования метода: `then().body(matchesJsonSchemaInClasspath())` из `<artifactId>json-schema-validator</artifactId>`
- 
- 
- 
- 
- 
- 
На доизучить:

- Как преобразовать в pojo средствами фреймворка? Jackson или Gson, в зависимости от того, что находится в classpath. 
Для преобразования в XML используется JAXB. Формат определяется автоматически по Content-Type.
`given().contentType(ContentType.JSON).body(somePojo)
  .when().post(EndPoints.add)
  .then()
  .statusCode(201);`\
`// то же самое работает и в обратную сторону:
SomePojo pojo = given()
.when().get(EndPoints.get)
.then().extract().body().as(SomePojo.class);`
- GROOVY
 методы `find`, `findAll` применяются к коллекции для поиска первого и всех вхождений, метод collect для  создания новой коллекции из найденных результатов.

переменная `it` создается неявно и указывает на текущий элемент коллекции
`Map<String, ?> map = get(EndPoints.anyendpoint).path("rootelement.find { it.title =~ 'anythingRegExp'}");`

можете явно задать название переменной, указывающей на текущий элемент
`Map<String, ?> map = get(EndPoints.anyendpoint).path("rootelement.findAll { element -> element.title.length() > 4 }");`

вы можете использовать методы sum, max, min для суммирования всех значений коллекции, а также поиска максимального и минимально значения
`String expensiveCar = get(EndPoints.cars).path("cars.find { it.title == 'Toyota Motor Corporation'}.models.max { it.averagePrice }.title");`

- Несколько проверок в одном запросе: `given().cookie(«key», «value»)
  .when().get(«someUrl»)
  .then().statusCode(200).body(matchesJsonSchemaInClasspath(«schema.json»)).cookie(«newCookie»);`\
  В данном случае будет 3 проверки: Статус код соответствует 200; Тело ответа соответствует Json Schema; В ответ пришел новый куки с ключом «newCookie».
- Для лучшей читабельности можно использовать вызов союза and():
  `...then().statusCode(200)
  .and()
  .body(matchesJsonSchemaInClasspath(«schema.json»))
  .and()
  .cookie(«newCookie»);`
  Терминальными методами являются только методы, вызываемые после метода extract():
  `...then().statusCode(200).extract().body().asString();`
- стоит ли десерилизовать ответ в класс или можно обойтись матчерами Hamcrest прямо в методе body()? 
Десериализация может понадобиться, например, для осуществления долгосрочного хранения или преобразования сущности в другой формат.

###Тест 1
- Используя сервис https://reqres.in/ получить список пользователей со второй (2) страницы
- Убедиться что имена файлов-аватаров пользоваталей совпадают:
- Убедиться, что email пользователей имеет окончание reqres. in;
###Тест 2.1
- Используя сервис https://reqres.in/ протестировать регистрацию пользователя в системе
- Необходимо создание 2 тестов:
- успешная регистрация

###Тест 2.2
- регистрация с ошибкой из-за отсутствия пароля. Проверить коды ошибок.
###Тест 3
  
  Используя сервис https://regres.in/ убедиться, что операция LIST<RESOURCE> возвращает данные, отсортированные по годам.
  
###Тест 4.1
Используя сервис https://reqres.in/ попробовать удалить второго пользователя и сравнить статус-код
###Тест 4.2
Используя сервис https://regres.in/ обновить информацию о пользователе и сравнить дату обновления с текущей датой на машине




###SWAPI.DEV
дока https://swapi.dev/documentation#auth
All resources support JSON Schema. Making a request to /api/<resource>/schema will give 
you the details of that resource. This will allow you to programmatically inspect 
the attributes of that resource and their types.