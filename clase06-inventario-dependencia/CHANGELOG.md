# Changelog — clase06.inventario.dependencia

Formato de versión: `MAJOR.MINOR.PATCH` (versionado semántico / SemVer).

- **MAJOR** sube cuando hay un cambio incompatible (rompe a quien ya usa la librería).
- **MINOR** sube cuando se agrega algo nuevo sin romper lo existente.
- **PATCH** sube cuando se corrige un bug sin cambiar la API pública.

## [1.0.0] - 2026-08-20

- Primera versión publicada.
- `Producto`: modelo con `id`, `nombre`, `categoria`, `precio`, `stock`.
- `InventarioService`:
  - `agregarProducto(Producto producto)`
  - `List<Producto> obtenerTodos()`
  - `Producto buscarPorId(int id)`

## [1.1.0] - 2026-08-25
> Se agregó `obtenerPorCategoria(String categoria)` a `InventarioService`.
> - No se modificó ni se eliminó ningún método de la 1.0.0 — por eso es
>   un cambio MINOR (1.0.0 → 1.1.0) y no MAJOR.
