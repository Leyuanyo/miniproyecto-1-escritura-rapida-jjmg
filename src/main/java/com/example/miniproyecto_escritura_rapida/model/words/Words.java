package com.example.miniproyecto_escritura_rapida.model.words;

import java.util.Random;

/**
 * Implementation of the {@link IWords} interface.
 * Manages the word bank for the Escritura Rapida typing game.
 * Contains a collection of 500 words related to Dark Souls lore,
 * Java programming, JavaFX, and general programming concepts.
 * Provides methods to randomly generate words and validate player input.
 *
 * @author Juan José Morera Gómez
 * @version 1.0
 * @since 1.0
 * @see IWords
 */
public class Words implements IWords {

    /** Random instance used to select words from the word bank. */
    private Random random;

    /** Array containing all available words for the game. */
    private String [] words;

    /** The word currently displayed to the player. */
    private String currentWord;

    /**
     * Constructs a new Words instance.
     * Initializes the random number generator and populates the word bank
     * with 500 words from Dark Souls lore, Java, JavaFX, and general
     * programming concepts.
     *
     * @since 1.0
     */
    public Words(){
        random = new Random();
        words = new String[]{
                "gwyn", "sif", "ornstein", "smough", "artorias", "ciaran", "gough", "velka",
                "gwyndolin", "priscilla", "quelaag", "mildred", "eingyi", "solaire", "siegmeyer",
                "sieglinde", "patches", "laurentius", "griggs", "logan", "frampt", "kaathe",
                "anastacia", "petrus", "reah", "lautrec", "andre", "domhnall", "rickert",
                "dusk", "manus", "seath", "nito", "witch", "nashandra", "aldia", "vendrick",
                "lucatiel", "benhart", "creighton", "pate", "mild", "gavlan", "carhillion",
                "gilligan", "laddersmith", "rosabeth", "ornifex", "titchy", "agdayne",
                "lordran", "firelink", "undead", "parish", "darkroot", "garden", "blighttown",
                "quelaana", "depths", "sewers", "basin", "forest", "asylum", "shrine",
                "anor", "londo", "izalith", "tomb", "dukes", "archives", "kiln", "first",
                "flame", "drangleic", "majula", "heide", "bastille", "huntsmans", "earthen",
                "peak", "shaded", "woods", "doors", "pharros", "grave", "harvest", "valley",
                "iron", "keep", "altar", "sunken", "king", "domain", "dragon", "shrine",
                "estus", "bonfire", "ember", "hollowing", "invasion", "covenant", "humanity",
                "kindling", "homeward", "parry", "riposte", "backstab", "stamina", "poise",
                "absorption", "resistance", "attunement", "endurance", "vitality", "adaptability",
                "encumbrance", "durability", "reinforcement", "infusion", "ascension", "upgrade",
                "transposition", "hollowed", "undead", "curse", "phantom", "summon", "sign",
                "ring", "armor", "shield", "weapon", "miracle", "pyromancy", "sorcery",
                "faith", "intelligence", "dexterity", "strength", "agility", "luck",
                "hollow", "skeleton", "zombie", "ghost", "wraith", "basilisk", "hydra",
                "dragon", "wyvern", "gargoyle", "golem", "sentinel", "silver", "black",
                "knight", "darkwraith", "channeler", "painting", "guardian", "titanite",
                "demon", "chaos", "asylum", "taurus", "capra", "moonlight", "butterfly",
                "darkroot", "titanite", "slime", "mimic", "chest", "vagrant", "crystal",
                "cave", "blowdart", "sniper", "archer", "crossbow", "spear", "sword",
                "clase", "objeto", "metodo", "atributo", "constructor", "herencia", "interfaz",
                "polimorfismo", "encapsulamiento", "abstraccion", "paquete", "importar",
                "instancia", "estatico", "publico", "privado", "protegido", "final",
                "abstracto", "sobreescribir", "sobrecargar", "retorno", "parametro",
                "argumento", "variable", "constante", "arreglo", "cadena", "entero",
                "flotante", "doble", "booleano", "caracter", "nulo", "vacio", "nuevo",
                "condicional", "iteracion", "bucle", "mientras", "para", "hacer",
                "interruptor", "caso", "romper", "continuar", "retornar", "lanzar",
                "atrapar", "finalmente", "intentar", "excepcion", "error", "pila",
                "cola", "lista", "mapa", "conjunto", "iterador", "generico", "coleccion",
                "arreglo", "vector", "matriz", "tabla", "indice", "longitud", "tamanio",
                "superclase", "subclase", "implementar", "extender", "anular", "abstracto",
                "concreto", "sellado", "anotacion", "enumeracion", "registro", "modulo",
                "reflexion", "serializacion", "clonable", "comparable", "funcional",
                "lambda", "stream", "opcional", "referencia", "metodo", "interfaz",
                "predicate", "function", "consumer", "supplier", "operador", "comparador",
                "escena", "escenario", "nodo", "boton", "etiqueta", "campo", "texto",
                "imagen", "vista", "panel", "diseno", "ancla", "cuadricula", "pila",
                "borde", "flujo", "pestania", "acordeon", "tabla", "columna", "fila",
                "lista", "combo", "selector", "deslizador", "barra", "progreso", "menu",
                "elemento", "separador", "herramienta", "estado", "contexto", "dialogo",
                "alerta", "confirmacion", "archivo", "color", "fuente", "cursor", "tooltip",
                "evento", "manejador", "escucha", "accion", "raton", "teclado", "tactil",
                "arrastrar", "soltar", "presionar", "liberar", "mover", "entrar", "salir",
                "clic", "doble", "derecho", "rueda", "desplazar", "tecla", "codigo",
                "modificador", "control", "mayus", "alt", "enter", "escape", "espacio",
                "retroceso", "suprimir", "inicio", "fin", "arriba", "abajo", "izquierda",
                "algoritmo", "estructura", "dato", "tipo", "funcion", "procedimiento",
                "recursion", "iteracion", "compilar", "ejecutar", "depurar", "probar",
                "refactorizar", "optimizar", "documentar", "versionar", "repositorio",
                "rama", "commit", "fusion", "solicitud", "revision", "despliegue",
                "servidor", "cliente", "protocolo", "peticion", "respuesta", "estado",
                "codigo", "binario", "hexadecimal", "decimal", "logica", "circuito",
                "patron", "diseno", "fabrica", "singleton", "observador", "estrategia",
                "decorador", "adaptador", "fachada", "proxy", "comando", "iterador",
                "plantilla", "estado", "visitante", "mediador", "memento", "prototipo",
                "constructor", "puente", "compuesto", "cadena", "responsabilidad",
                "interprete", "modelo", "vista", "controlador", "repositorio", "servicio",
                "tabla", "columna", "fila", "indice", "llave", "primaria", "foranea",
                "consulta", "insertar", "actualizar", "eliminar", "seleccionar", "unir",
                "filtrar", "agrupar", "ordenar", "transaccion", "confirmacion", "revertir",
                "normalizar", "relacion", "entidad", "atributo", "esquema", "vista",
                "procedimiento", "trigger", "cursor", "secuencia", "particion", "replica",
                "protocolo", "direccion", "puerto", "socket", "conexion", "solicitud",
                "respuesta", "encabezado", "cuerpo", "metodo", "recurso", "ruta",
                "parametro", "autenticacion", "autorizacion", "sesion", "token", "cookie",
                "cifrado", "certificado", "servidor", "cliente", "proxy", "balanceo",
                "carga", "cache", "latencia", "ancho", "banda", "paquete", "enrutamiento"        };
    }

    /**
     * Returns the full word bank array.
     *
     * @return an array of {@code String} containing all available words
     * @since 1.0
     */
    public String[] getWords() {
        return words;
    }

    /**
     * Replaces the current word bank with a new array of words.
     *
     * @param words the new array of words to use as the word bank
     * @since 1.0
     */
    public void setWords(String[] words) {
        this.words = words;
    }

    /**
     * Generates and returns a random word from the word bank.
     * The selected word is stored as the current word for subsequent validation.
     *
     * @return a randomly selected word as a {@code String}
     * @since 1.0
     */
    @Override
    public String generateWord() {
        int randomNumber = random.nextInt(words.length);
        currentWord = words[randomNumber];
        return currentWord;
    }

    /**
     * Validates the player's input against the current word.
     *
     * @param userWord the word typed by the player
     * @return {@code true} if the player's input matches the current word,
     *         {@code false} otherwise
     * @since 1.0
     */
    @Override
    public Boolean validateWord(String userWord) {
        return currentWord.equals(userWord);
    }

}
