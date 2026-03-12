module com.example.miniproyecto_escritura_rapida {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    requires java.desktop;


    opens com.example.miniproyecto_escritura_rapida to javafx.fxml;
    opens com.example.miniproyecto_escritura_rapida.controller to javafx.fxml;
    exports com.example.miniproyecto_escritura_rapida;
    opens com.example.miniproyecto_escritura_rapida.model.game to javafx.fxml;
    opens com.example.miniproyecto_escritura_rapida.model.time to javafx.fxml;
    opens com.example.miniproyecto_escritura_rapida.model.words to javafx.fxml;
}