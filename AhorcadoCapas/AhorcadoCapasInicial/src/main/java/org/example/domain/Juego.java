package org.example.domain;

public class Juego {
    private Elemento aAdivinar;
    private Jugador jugador;
    private int intentos;

    public Juego(Jugador jugador, Elemento aAdivinar){
        this.jugador= jugador;
        this.aAdivinar= aAdivinar;
        intentos=0;
    }

    1. import random

  2. IMÁGENES_AHORCADO = ['''

            3.

            4.   +---+

            5.   |   |

            6.       |

            7.       |

            8.       |

            9.       |

            10. =========''', '''

            11.

            12.   +---+

            13.   |   |

            14.   O   |

            15.       |

            16.       |

            17.       |

            18. =========''', '''

            19.

            20.   +---+

            21.   |   |

            22.   O   |

            23.   |   |

            24.       |

            25.       |

            26. =========''', '''

            27.

            28.   +---+

            29.   |   |

            30.   O   |

            31.  /|   |

            32.       |

            33.       |

            34. =========''', '''

            35.

            36.   +---+

            37.   |   |

            38.   O   |

            39.  /|\  |

            40.       |

            41.       |

            42. =========''', '''

            43.

            44.   +---+

            45.   |   |

            46.   O   |

            47.  /|\  |

            48.  /    |

            49.       |

            50. =========''', '''

            51.

            52.   +---+

            53.   |   |

            54.   O   |

            55.  /|\  |

            56.  / \  |

            57.       |

            58. =========''']

}
