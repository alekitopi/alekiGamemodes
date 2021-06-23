# alekiGamemodes
> Cambia fácilmente los modos de juego de tus usuarios.


## Mensajes
Para la mayor personalización posible del plugin, existe la posibilidad de cambiar prácticamente cualquier mensaje modificando un simple archivo. Este es un ejemplo del mismo:
```yaml
prefix: "&6&laGamemodes &8» &f"
noperms: "{prefix} &cNo tienes permisos suficientes."
onlyplayer: "{prefix} &cEste comando solo puede ser ejecutado por un jugador."
playeroffline: "{prefix} &cEse jugador no está conectado."
gamemode:
  usage: "{prefix} &cEl uso correcto del comando es: &4/gamemode <0/1/2/3> [jugador]"
  changed: "{prefix} &fTu modo de juego ha sido cambiado &fa &d{mode}&f."
  changedother: "{prefix} &fHas cambiado &fel modo de juego de &5&l{player} &fa &d{mode}&f."
  modes:
    survival: "survival"
    creative: "creativo"
    adventure: "aventura"
    spectator: "espectador"
```

## Permisos
| Permiso                | Descripción                                       |
|------------------------|---------------------------------------------------|
| agm.gamemode.*         | Permite utilizar el comando por completo.         |
| agm.gamemode.survival  | Permite cambiar su modo de juego a supervivencia. |
| agm.gamemode.creative  | Permite cambiar su modo de juego a creativo.      |
| agm.gamemode.adventure | Permite cambiar su modo de juego a aventura.      |
| agm.gamemode.spectator | Permite cambiar su modo de juego a espectador.    |
