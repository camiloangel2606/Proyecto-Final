INFORME DE PROYECTO FINAL 
PROGRAMACIÓN II








PRESENTADO POR: 
CAMILO STEVEN ANGEL VELASQUEZ
JOSE ALEJANDRO RODRIGUEZ VALENCIA









FECHA:
14/06/2024






UNIVERSIDAD DE CALDAS







Carpeta Main
Sistema de gestión para servicios de nutrición, con funcionalidades como registro y gestión de pacientes, dietistas, planes de dieta y comidas. Utiliza archivos CSV para almacenar y cargar datos persistentes. Aquí tienes un resumen corto del funcionamiento:

-Main Class: Gestiona un menú interactivo con opciones para gestionar pacientes, dietistas, planes de dieta y registro de comidas.

-CSVPatient y CSVDietitian: Clases auxiliares para cargar y guardar datos de pacientes y dietistas desde y hacia archivos CSV.

-PatientService: Permite registrar, actualizar y eliminar pacientes, además de asignarles planes de dieta y comidas.

-Dietitian Class: Modelo que representa a un dietista con métodos para añadir y listar dietistas con sus especialidades.

-DietPlan Class: Modelo que define un plan de dieta con detalles como ID, calorías diarias, distribución de macronutrientes y recomendaciones específicas.

-Meal Class: Modelo para representar comidas con métodos para registrar nuevas comidas en archivos CSV.

-El programa utiliza entrada de usuario para gestionar datos y ofrece una interfaz interactiva para interactuar con el sistema de manera intuitiva.

Carpeta Services
El objetivo principal es proporcionar una visión clara sobre cómo se estructuran y operan las diferentes clases y métodos dentro del sistema.

1. DietitianService
-El servicio DietitianService se encarga de la gestión de los dietistas registrados en el sistema.

-Constructor (DietitianService()): Inicializa el servicio y carga la información existente desde un archivo CSV, si lo hubiera.

-Método addDietitian(int dietitianId, String fullName, String[] preexistingConditions): Permite agregar un nuevo dietista al sistema. Verifica si el dietista ya está registrado antes de agregarlo. Capitaliza el nombre del dietista y guarda la información actualizada en el archivo CSV.

-Método printDietitianList(): Imprime la lista de todos los dietistas registrados en el sistema.

2. DietPlanService
-El servicio DietPlanService maneja la gestión de los planes de dieta.

-Método addDietPlan(DietPlan dietPlan): Agrega un nuevo plan de dieta a la lista de planes existentes.

-Método printDietPlanList(): Imprime todos los planes de dieta registrados en el sistema.

-Método calculateTotalCalories(DietPlan dietPlan): Calcula y muestra el total de calorías de un plan de dieta sumando las calorías de todas las comidas incluidas en él.

-Método printDietPlanDetails(DietPlan dietPlan): Imprime los detalles específicos de un plan de dieta, incluyendo el nombre del paciente, el dietista responsable, las calorías diarias, la distribución de macronutrientes, las recomendaciones específicas y las comidas planificadas.

3. MealService
-El servicio MealService administra las comidas disponibles en el sistema.

-Método addMealToList(Meal meal): Agrega una nueva comida a la lista de comidas disponibles.

-Método getMealList(): Retorna la lista completa de todas las comidas registradas en el sistema.

4. PatientService
-El servicio PatientService gestiona la información de los pacientes y sus interacciones con los planes de dieta y comidas.

-Método addPatient(...) y updatePatient(...): Permite agregar nuevos pacientes al sistema o actualizar la información de pacientes existentes. Verifica la existencia del paciente por su ID antes de realizar cualquier cambio y guarda la información actualizada en archivos CSV.

-Método removePatient(int patientId): Elimina un paciente del sistema según su ID. Además, actualiza la información almacenada eliminando al paciente correspondiente del archivo CSV.

-Método getPatientById(int id): Retorna un paciente específico buscado por su ID.

-Métodos relacionados con comidas y planes de dieta (addMealToPatient(...), addDietPlanToPatient(...), etc.): Permiten asociar comidas y planes de dieta específicos a un paciente determinado. Verifican la existencia del paciente por su ID antes de realizar cualquier modificación y actualizan la información en el archivo CSV correspondiente.

Carpeta Models
Se detallan tres clases ubicadas en el paquete Models, las cuales son fundamentales para la representación y gestión de datos relacionados con dietistas, planes de dieta y comidas dentro de una aplicación de gestión de salud y dietas.

1. Dietitian
Propósito y Funcionalidad:
La clase Dietitian representa a un dietista dentro del sistema, extendiendo la clase Patient. Aquí se maneja la información específica del dietista, como su identificación, nombre completo y condiciones preexistentes.

Constructores:

-Dietitian(int dietitianId, String fullName, List<String> preexistingConditions): Constructor que inicializa un dietista con un ID, nombre completo y condiciones preexistentes.
Dietitian(): Constructor vacío que inicializa un dietista con valores por defecto.
Métodos:

addDietitian(int dietitianId, String fullName, String[] preexistingConditionsArray): Método estático que agrega un dietista al archivo CSV Data/Dietitian.csv con los datos proporcionados.
capitalizeName(String name): Método estático auxiliar para capitalizar la primera letra de cada palabra en un nombre.
Atributos:

dietitianId: Identificación única del dietista.
fullName: Nombre completo del dietista, capitalizado.
preexistingConditions: Lista de condiciones preexistentes del dietista.

2. DietPlan
Propósito y Funcionalidad:
La clase DietPlan representa un plan de dieta personalizado para un paciente, que incluye información sobre el ID del plan, calorías diarias, distribución de macronutrientes, recomendaciones específicas, el paciente asociado, el dietista a cargo y la lista de comidas incluidas en el plan.

Constructores:

-DietPlan(): Constructor vacío.
-DietPlan(int planId, float dailyCalories, String macronutrientDistribution, String specificRecommendations, Patient patient, Dietitian dietitian, List<Meal> meals): Constructor que inicializa un plan de dieta con todos los detalles especificados.

Métodos:

-Getters y Setters: Métodos para acceder y modificar los atributos privados de la clase.
-toString(): Override del método para representar de manera legible la información del objeto -DietPlan.
Atributos:

-planId: Identificación única del plan de dieta.
-dailyCalories: Calorías diarias recomendadas en el plan.
-macronutrientDistribution: Distribución de macronutrientes recomendada.
-specificRecommendations: Recomendaciones específicas adicionales para el paciente.
-patient: Paciente asociado al plan de dieta.
-dietitian: Dietista a cargo del plan de dieta.
-meals: Lista de comidas incluidas en el plan.
3. Meal
Propósito y Funcionalidad:
La clase Meal representa una comida específica dentro del sistema, con detalles como nombre, ingredientes, macronutrientes, calorías y momento del día.

Constructores:

-Diversos constructores: Varios constructores que permiten crear objetos Meal con diferentes combinaciones de atributos.
Métodos:

-saveMealsToCSV(List<Meal> meals): Método estático que guarda la lista de comidas en un archivo CSV llamado meal_plan.csv.
-addMealToCSV(String fileName, int id, String name, float portion): Método estático para agregar una comida específica al archivo CSV especificado.
-Getters y Setters: Métodos para acceder y modificar los atributos privados de la clase.
-toString(): Override del método para representar de manera legible la información del objeto Meal.
Atributos:

-id: Identificación única de la comida.
-name: Nombre de la comida.
-ingredient1-5: Ingredientes principales de la comida.
-timeOfDay: Momento del día para el cual está destinada la comida.
-calories: Calorías contenidas en la comida.
-macronutrients: Distribución de macronutrientes de la comida.
-mealList: Lista estática de comidas, utilizada para almacenar todas las instancias de Meal.

4.Patient
Estructura y Propósito
La clase Patient almacena información detallada sobre un paciente, incluyendo su identificación, nombre completo, año de nacimiento, peso, altura, condiciones preexistentes, plan de comidas y plan de dieta asignado.

Constructores:

-Patient(): Constructor vacío que inicializa un paciente con valores por defecto.
-Patient(int patientId, String fullName, int birthYear, float weight, float height, List<String> preexistingConditions): Constructor que inicializa un paciente con todos los atributos específicos proporcionados.
-Métodos Estáticos:

-getPatientById(int id): Método estático que busca un paciente por su identificación dentro de la lista de pacientes almacenada en PatientService.
-capitalizeName(String name): Método estático auxiliar para capitalizar la primera letra de cada palabra en un nombre.
Métodos de Instancia:
-getDietPlan(): Retorna el plan de dieta asignado al paciente.
-getMealPlan(): Retorna la lista de comidas planificadas para el paciente.
-Setters y Getters: Métodos para establecer y obtener los atributos privados de la clase, como nombre, edad (calculada a partir del año de nacimiento), peso, altura y condiciones preexistentes.
-toString(): Override del método para representar de manera legible la información del objeto Patient.
-Atributos Principales
-patientId: Identificación única del paciente.
-fullName: Nombre completo del paciente.
-birthYear: Año de nacimiento del paciente (usado en lugar de la edad).
-weight: Peso del paciente.
-height: Altura del paciente.
-preexistingConditions: Lista de condiciones preexistentes del paciente.
-mealPlan: Lista de comidas planificadas para el paciente.
-dietPlan: Plan de dieta asignado al paciente.
-Funcionalidades Clave
La clase Patient facilita la gestión y manipulación de datos relacionados con los pacientes dentro del sistema, permitiendo operaciones como la búsqueda de pacientes por ID, la asignación y consulta de planes de dieta, y el acceso a la lista de comidas planificadas.



Carpeta Helpers

Se detallan cuatro clases ubicadas en el paquete Helpers, las cuales facilitan la gestión de datos estructurados en formato CSV dentro de una aplicación de gestión de dietas y pacientes.

1. CSVDietitian
Propósito y Funcionalidad:
La clase CSVDietitian se encarga de manejar la información relacionada con los dietistas. Su función principal es leer y escribir datos de dietistas desde y hacia un archivo CSV, ubicado en Data/Dietitian.csv.

-loadInfo(): Lee los datos de dietistas desde el archivo CSV y los carga en una lista para su posterior uso en la aplicación. Utiliza el servicio DietitianService para añadir los dietistas a la lógica de negocio.

-saveInfo(List<Dietitian> dietitians): Guarda la lista actualizada de dietistas en el archivo CSV, sobrescribiendo los datos existentes.

-writeToFile(String filePath, List<Dietitian> dietitians): Método auxiliar que escribe los datos de los dietistas en el archivo CSV especificado.

-readFromFile(String filePath, List<Dietitian> dietitians): Método auxiliar que lee y procesa los datos de dietistas desde el archivo CSV, convirtiéndolos en objetos Dietitian y agregándolos a la lista proporcionada.

2. CSVDietPlan
Propósito y Funcionalidad:
Esta clase facilita la lectura de opciones de alimentos específicos desde archivos CSV, utilizados para la generación de planes de dieta personalizados. Cada método corresponde a un grupo de alimentos particular y carga sus opciones desde un archivo CSV correspondiente.

-readCheesesAndSubstitutes(): Lee las opciones de quesos y sustitutos desde el archivo cheeses_and_substitutes.csv.

-readFloursCerealsAndDerivados(): Lee las opciones de harinas, cereales y derivados desde el archivo flours_cereals_and_derivados.csv.

-readFruits(): Lee las opciones de frutas desde el archivo fruits.csv.

-readFats(): Lee las opciones de grasas desde el archivo fats.csv.

-readLeguminosas(): Lee las opciones de leguminosas desde el archivo leguminosas.csv.

-readLeanMeats(): Lee las opciones de carnes magras desde el archivo lean_meats.csv.

-readVegetables(): Lee las opciones de verduras desde el archivo vegetables.csv.

-readNutsAndSeeds(): Lee las opciones de nueces y semillas desde el archivo nuts_and_seeds.csv.

Cada método utiliza un enfoque de lectura de archivos para construir listas de opciones específicas de alimentos que pueden ser utilizadas dinámicamente en la aplicación.

3. CSVMeal
Propósito y Funcionalidad:
La clase CSVMeal se encarga de gestionar la información relacionada con las comidas en formato CSV. Permite leer y escribir datos de comidas desde y hacia un archivo CSV ubicado en Data/Meals.csv.

-loadInfo(): Lee los datos de comidas desde el archivo CSV y los carga en una lista para su posterior uso en la aplicación. Utiliza el método addMealToList() de la clase Meal para agregar las comidas a una lista estática.

-saveInfo(List<Meal> meals): Guarda la lista actualizada de comidas en el archivo CSV, sobrescribiendo los datos existentes.

-writeInfo(List<Meal> meals): Método opcional para escribir datos de comidas en el archivo CSV, aunque no está utilizado explícitamente en el código proporcionado.

-writeToFile(String filePath, List<Meal> meals): Método auxiliar que escribe los datos de las comidas en el archivo CSV especificado.

-readFromFile(String filePath, List<Meal> meals): Método auxiliar que lee y procesa los datos de comidas desde el archivo CSV, convirtiéndolos en objetos Meal y agregándolos a la lista proporcionada.

4. CSVPatient
Propósito y Funcionalidad:
La clase CSVPatient gestiona la información de los pacientes en formato CSV. Permite leer y escribir datos de pacientes desde y hacia un archivo CSV ubicado en Data/Patients.csv.

-loadInfo(): Lee los datos de pacientes desde el archivo CSV y los carga en una lista para su posterior uso en la aplicación. Utiliza el servicio PatientService para añadir los pacientes a la lógica de negocio.

-saveInfo(List<Patient> patients): Guarda la lista actualizada de pacientes en el archivo CSV, sobrescribiendo los datos existentes.

-writeToFile(String filePath, List<Patient> patients): Método auxiliar que escribe los datos de los pacientes en el archivo CSV especificado.

-readFromFile(String filePath, List<Patient> patients): Método auxiliar que lee y procesa los datos de pacientes desde el archivo CSV, convirtiéndolos en objetos Patient y agregándolos a la lista proporcionada.
