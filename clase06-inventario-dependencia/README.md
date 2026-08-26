# clase06-inventario-dependencia

Esta carpeta **no se ejecuta sola** — es la dependencia (librería) que
consume `clase06-inventario-handler`. El taller completo, con las
instrucciones para la clase, está en el README de esa otra carpeta.

## Qué es

Mismo patrón que ya vieron en `clase2.util` / `clase2.handler`: un
proyecto Maven propio que se instala en el repositorio local
(`~/.m2`) con `mvn install`, y otro proyecto (`clase06-inventario-handler`)
lo agrega como `<dependency>` en su `pom.xml`.

- `Producto`: modelo del dominio (id, nombre, categoría, precio, stock).
- `InventarioService`: la API pública — los métodos que el handler puede
  llamar.

## Instalarla en el repositorio local

```bash
cd clase06-inventario-dependencia
mvn install
```

Esto compila la librería y la copia a `~/.m2/repository/umg/edu/gt/progra2/clase06.inventario.dependencia/1.0.0/`.
Desde ahí, cualquier otro proyecto Maven en tu máquina (como el handler)
puede declararla como dependencia por `groupId:artifactId:version`, sin
necesidad de un repositorio remoto.

## Ver `CHANGELOG.md`

Ahí se documenta qué trae cada versión. Es el archivo que van a completar
cuando hagan el "Paso 2" del taller (agregar un método nuevo y publicar
la `1.1.0`).
