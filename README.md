# MHWEventos
A continuación analizare y explicare el código
clase por clase con ayuda de imágenes.
Clase Event
Esta clase está compuesta por las siguientes
variables junto con el constructor y los getters
autogenerados. No hay setters ya que no son
necesarios al no hacer ningún POST a laAPI
El implements Serializable es necesario para
poder hacer del objeto Event un serializable
para utilizarlo mas adelante.
Al igual que la clase Event, esta clase solo
contiene un constructor y los getters de las
siguientes variables.
Esta clase, al igual que la clase Event y la clase
Maps, necesita el implements Serializable ya
que las tres clases están relacionadas.
En la clase Event, la variable location es de tipo
Mapa, que a su vez tiene una variable de tipo
ArrayList<Camps>llamada camps.
Clase Mapa
Clase Camp
Esta clase tiene las siguientes
variables.
Clase MainActivity
Esta es la clase principal de la aplicación.
En ella hay tres botones los cuales se declaran e
inicializan de la siguiente manera,
Para el manejo del clic de los botones es
necesario añadir lo siguiente a la clase,
Esto necesita que se implemente la función
onClick para la gestión de los botones y su
funcionalidad. Cada botón envía un valor
distinto mediante el Intent para manejar el
filtro de la llamada GET.
La clase EventList se encarga de mostrar la lista
de eventos mediante una RecyclerView con la
ayuda de la clase EventsAdapter.
Esta clase extiende e implementa lo siguiente,
Clase EventList
Contiene un RecyclerView y un EventAdapter y
se inicializan de la siguiente manera,
La función llenarLista se encarga, como su
nombre indica, de añadir los campos al
RecyclerView.
La función llenarLista contiene una variable
llamada expansión que se encarga de
almacenar el dato recibido mediante el Intent
desde los botones del MainActivity.
Con la ayuda de Retrofit y Gson, establecemos
la dirección de la API y transformamos los datos
recibidos para amoldarlos a nuestros objetos
Esto ultimo hace uso de la interfaz mhwAPI
donde están los tres @GET distintos usados en
esta clase.
El siguiente código está repetido tres veces con
la única diferencia en la función a la que llaman
dependiendo del valor de la variable expansion.
Si el valor es 0, se ejecutará el siguiente código.
Si el valor es 1, se ejecutará el mismo código
con la diferencia de que llamará a la función
getEventsI() en lugar de getEvents(). Y si el valor
es 2, hará lo mismo pero con la función
getAllEvents().
La clase EventList también contiene la función
click la cual sirve para implementar la
funcionalidad de pulsar un elemento de la lista
y que aparezca una ventana con más
información sobre este.
Para el correcto uso de esta función era
necesario implementar Serializable en las otras
clases.
Esta es la interfaz donde se declaran las
funciones de @GET y se especifica el contenido
de estos @GET.
En este caso, a causa del mal estado de la API
no se ha podido filtrar por expansión como
estaba previsto asi que se ha filtrado por rango
de misión para tener una idea visual del
prototipo.
Para filtrar por expansión se utilizaría el
siguiente código.
Interfaz mhwAPI
Esta clase es la complementaria a la clase
EventList ya que sin esta no se podría mostrar
la lista de eventos.
La función onCreateViewHolder crea un holder
con la view de event_layout
Clase EventsAdapter
La función onBindViewHolder enlaza los datos
que se desea mostrar con el holder.
La función setList llena la lista con la lista de
eventos, aqui había un filtro para solo mostrar
los eventos disponibles actualmente pero la API
no funciona correctamente por lo que
actualmente esta funcionalidad esta
desactivada.
Dentro de esta clase estála clase ViewHolder la
cual tiene una función en la que inicializa los
TextView del Holder.
Por último esta la clase DetallesEvent la cual
sirve para mostrar más información sobre la
misión seleccionada en la lista.
Clase DetallesEvent
Los TextViews corresponden a los datos que se
quieren mostrar.
En la función onCreate se inicializan los
TextViews y se les asigna el valor
correspondiente.
