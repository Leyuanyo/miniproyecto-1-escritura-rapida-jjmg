package com.example.miniproyecto_escritura_rapida.model.words;

import java.util.Random;

public class Words implements IWords {
    private Random random;
    private String [] words;
    private String currentWord;

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

    public String[] getWords() {
        return words;
    }

    public void setWords(String[] words) {
        this.words = words;
    }

    @Override
    public String generateWord() {
        int randomNumber = random.nextInt(words.length);
        currentWord = words[randomNumber];
        return currentWord;
    }

    @Override
    public Boolean validateWord(String userWord) {
        return currentWord.equals(userWord);
    }

}
