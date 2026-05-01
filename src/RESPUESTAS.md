Una ontología se define, dentro del campo de la computación, como una red o sistema de datos que define las relaciones existentes entre conceptos de un área de conocimiento. Un grafo de conocimiento es una forma de unir conceptos entre sí. 

Los nodos actúan como conceptos y las aristas o arcos son jerarquías o propiedades entre ellos.
Esta estructura nos permite visualizar las relaciones entre múltiples datos dentro de un dominio,
concretamente ver las relaciones entre distintos científicos o ganadores del Nobel respecto a Albert
Einstein. 

Para nuestro caso concreto, trabajamos definiendo los tipos Persona, Lugar y Premio, los distintos
tipos de nodo con los que cuenta el grafo. Las relaciones entre ellos las definimos con "nace_en",
"premio:Nobel", etc. Así podremos consultar desde el grafo las ciudades natales de los premiados
con el Nobel, o el menor camino (menor numero de relaciones) entre Einstein y Viena, por ejemplo.
