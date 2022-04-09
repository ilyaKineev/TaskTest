Написать простое REST приложение, реализующее функционал трекера задач (реализация фронта – по желанию, достаточно
взаимодействия через http клиент – postman, jars, soapUI и т.д.

* endpoint возвращает список существующих задач
* endpoint возвращает задачу по номеру, если ее не существует возвращает соответствующую ошибку
* endpoint на основе полученных данных - заголовок задачи и краткое описание создает задачу в любой реляционной БД (по
  желанию возможно использовать не реляционные)
* endpoint редактирования задачи
* endpoint удаления задачи

Написать инструкцию по запуску приложения. Выложить проект в github, прислать ссылку на проект. Выбор используемых
технологий, не требуемых в условиях задачи -- на Ваше усмотрение.

## TaskTracker

### Make things easier for your teammates with a complete collection description.

#### GET

getTaskAll - Получить все Задачи 

curl -X GET http://localhost:8080/task

#### GET

getTaskById - Получить задачу по Id

curl -X GET http://localhost:8080/task/2

#### POST

updateTaskById - Обновить задачу по Id

curl -H "Content-Type: application/json" -X POST -d ' {"nameTask": "NameTask","task" : "NewTask" }' http://localhost:8080/task/1

#### POST

createTask - Создатьт задачу

curl -H "Content-Type: application/json" -X POST -d '{"nameTask": "NewTask","task": "Task"}'  http://localhost:8080/task

#### DELETE - Удалить задачу по Id

removeTaskById

curl -X DELETE http://localhost:8080/task/1