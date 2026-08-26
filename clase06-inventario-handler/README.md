# Clase 6 — Colecciones + Versionado de una dependencia propia

Jueves 20 de agosto de 2026.

## Antes de empezar: instalar la dependencia

Este proyecto (el handler) **no compila solo** — necesita la librería
`clase06-inventario-dependencia` instalada en tu repositorio Maven local.

```bash
cd ../clase06-inventario-dependencia
mvn install
```

Con eso queda disponible como `umg.edu.gt.progra2:clase06.inventario.dependencia:1.0.0`
para cualquier proyecto en tu máquina (exactamente el mismo mecanismo que
`clase2.util` / `clase2.handler`, solo que ahora con un número de versión
real en vez de `-SNAPSHOT`).

## Cómo ejecutar el handler

**Eclipse:** File > Import > Existing Maven Projects, seleccionar
`clase06-inventario-handler` (Eclipse/m2e resuelve la dependencia contra
tu repositorio local). Ejecutar `Main.java` como Java Application.

**Terminal:**
```bash
cd clase06-inventario-handler
mvn compile exec:java
```

Si ves un error de "dependency not found", es porque falta el paso
anterior (`mvn install` en la carpeta de la dependencia).

## Contenido

| Proyecto | Qué es |
|---|---|
| `clase06-inventario-dependencia` | La librería: `Producto` (modelo) + `InventarioService` (API pública, versión 1.0.0) |
| `clase06-inventario-handler` | La app: `Main` (arma un inventario de ejemplo) + `PedidoHandler` (los ejercicios) |

## Idea clave de la clase

- Cuando tu código depende de una librería (propia o de terceros), esa
  librería tiene una **API pública**: el conjunto de clases y métodos que
  otros pueden usar. Cambiarla no es gratis.
- **Agregar** algo nuevo a esa API (un método) es un cambio **compatible**:
  quien ya la usaba sigue compilando sin tocar una línea.
- **Cambiar o borrar** algo que ya existía (nombre, parámetros, tipo de
  retorno) es un **breaking change**: rompe a todo el que ya la usaba.
- Por eso existe el versionado semántico (`MAJOR.MINOR.PATCH`): el número
  de versión le avisa a quien consume la dependencia qué tipo de cambio
  trae, antes de siquiera mirar el código. Ver `CHANGELOG.md` en la
  dependencia.

## Ejercicios: completar `PedidoHandler.java`

Son 6 métodos con `TODO`, cada uno resuelve una pregunta de negocio sobre
el inventario usando `List`, `Map` o `Set`. Cada `TODO` incluye qué debe
hacer, un ejemplo de entrada/salida y una pista de qué colección usar —
están pensados para completarse en 5-8 líneas cada uno.

1. `contarPorCategoria()` — `HashMap<String, Integer>` como contador.
2. `productosConStockBajo(int umbral)` — filtrar con `ArrayList`.
3. `categoriasDisponibles()` — categorías sin repetir con `HashSet`.
4. `productoMasCaro()` — recorrer comparando precios.
5. `indexarPorId()` — `HashMap<Integer, Producto>` para búsqueda rápida.
6. `valorTotalInventario()` — acumular `precio * stock`.

Pueden probar cada uno corriendo `Main.java` (`mvn compile exec:java`) y
comparando la salida con la esperada en el comentario de cada método.

**Criterio de evaluación:** el método compila, no modifica
`InventarioService` ni los otros métodos de `PedidoHandler`, y la salida
de `Main` coincide con el ejemplo documentado en cada `TODO`.

## Paso 2: versionar la dependencia sin romper el handler

Al final de `PedidoHandler.java` hay instrucciones paso a paso (numeradas
1-6) para:

1. Agregar un método nuevo a `InventarioService` (ej. `obtenerPorCategoria`).
2. Publicarlo como versión `1.1.0` (`mvn install` en la dependencia).
3. Actualizar **una sola línea** del `pom.xml` del handler
   (`<inventario.version>`).
4. Confirmar que todo lo que ya resolvieron en los TODOs 1-6 sigue
   compilando y funcionando **sin cambios**.
5. Usar el método nuevo desde un método adicional del handler.
6. Documentar el cambio en `CHANGELOG.md` de la dependencia.

Esa es la lección: una versión nueva y compatible no debería obligarte a
tocar el código que ya funcionaba — solo el número de versión.

## Reto opcional (para hacer en clase, no en el código)

Como demostración de lo contrario: si en `InventarioService` renombran
`buscarPorId` a, por ejemplo, `buscarPorCodigo` (o le cambian el tipo del
parámetro), reinstalan la dependencia y actualizan la versión en el
handler, `Main.java` va a dejar de compilar aunque no cambiaron ni una
línea de `PedidoHandler`. Eso es un **breaking change**: ese cambio
debería publicarse como `2.0.0`, no como `1.x.0`. No lo dejen así en su
repositorio — es solo para ver el error en vivo y después revertirlo.

## Tarea para la siguiente clase

Completar el "Paso 2" (versión 1.1.0) si no les alcanzó el tiempo en
clase, y subir ambos proyectos (`clase06-inventario-dependencia` y
`clase06-inventario-handler`) al repositorio.
