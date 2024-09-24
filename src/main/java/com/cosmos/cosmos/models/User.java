package com.cosmos.cosmos.models;


import com.azure.spring.data.cosmos.core.mapping.Container;
import com.azure.spring.data.cosmos.core.mapping.GeneratedValue;
import com.azure.spring.data.cosmos.core.mapping.PartitionKey;
import lombok.*;
import org.springframework.data.annotation.Id;

//este es nuestra tabla , osea en mysql es una tabla
// en cosmos es container, indicamos como se llamara "la tabla" en el emulador
@Container(containerName = "helloeveryonev1111")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class User {

    @Id
    @GeneratedValue
    private String id;

    @NonNull
    private String firstName;

    //cuando creas un container ,
    // en el emulador te pide un partition key, entonces en este caso establecemos el lastname, pero podria ser el que tu quieras
    //recuerda en el emulador debe de ser  con la "/" por ejemplo /lastname
    @NonNull
    @PartitionKey
    private String lastName;
}
