package org.academiadecodigo;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class InputHandler implements KeyboardHandler {


    private final Player player;

    private final Keyboard keyboard;
    private KeyboardEvent[] events;
    private KeyboardEvent[] released;
    private CollisionChecker collisionChecker = new CollisionChecker();

    public InputHandler(Player player) {

        this.player = player;
        keyboard = new Keyboard(this);
        createEvents();
    }

    private void createEvents() {
        events = new KeyboardEvent[11];

        for (int i = 0; i < events.length; i++) {
            events[i] = new KeyboardEvent();
        }

        events[0].setKey(KeyboardEvent.KEY_I);
        events[1].setKey(KeyboardEvent.KEY_UP);
        events[2].setKey(KeyboardEvent.KEY_DOWN);
        events[3].setKey(KeyboardEvent.KEY_LEFT);
        events[4].setKey(KeyboardEvent.KEY_RIGHT);
        events[5].setKey(KeyboardEvent.KEY_SPACE);
        events[6].setKey(KeyboardEvent.KEY_H);
        events[7].setKey(KeyboardEvent.KEY_J);
        events[8].setKey(KeyboardEvent.KEY_K);
        events[9].setKey(KeyboardEvent.KEY_L);
        events[10].setKey(KeyboardEvent.KEY_F);

        for (int i = 0; i < events.length; i++) {
            events[i].setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
            keyboard.addEventListener(events[i]);
        }

        KeyboardEvent keyboardEventSpaceTwice = new KeyboardEvent();
        keyboardEventSpaceTwice.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboardEventSpaceTwice.setKey(KeyboardEvent.KEY_SPACE);
        keyboard.addEventListener(keyboardEventSpaceTwice);
    }


        @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        int tileNum1, tileNum2;

        CollisionChecker c = new CollisionChecker();


        switch (keyboardEvent.getKey()) {

            case KeyboardEvent.KEY_UP:
                collisionChecker.checker(player, keyboardEvent);
                checkPokemon(player, keyboardEvent);
                break;
            case KeyboardEvent.KEY_DOWN:
                collisionChecker.checker(player, keyboardEvent);
                checkPokemon(player, keyboardEvent);
                break;
            case KeyboardEvent.KEY_LEFT:
                collisionChecker.checker(player, keyboardEvent);
                checkPokemon(player, keyboardEvent);
                break;
            case KeyboardEvent.KEY_RIGHT:
                collisionChecker.checker(player, keyboardEvent);
                checkPokemon(player, keyboardEvent);
                break;
            case KeyboardEvent.KEY_H:
                player.setPokemon(Pokemon.BULBASAUR);
                checkPokemon(player, keyboardEvent);
                break;
            case KeyboardEvent.KEY_J:
                player.setPokemon(Pokemon.SQUIRTLE);
                checkPokemon(player, keyboardEvent);
                break;
            case KeyboardEvent.KEY_K:
                player.setPokemon(Pokemon.CHARMANDER);
                checkPokemon(player, keyboardEvent);
                break;
            case KeyboardEvent.KEY_L:
                player.setPokemon(Pokemon.PIKACHU);
                checkPokemon(player, keyboardEvent);
                break;
            /*case KeyboardEvent.KEY_F:
                player.shootWeapon();*/
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }

    private void checkPokemon(Player player, KeyboardEvent keyboardEvent) {

        //region BULBASAUR
        if (player.getPokemon() == Pokemon.BULBASAUR) {

            //region H
            if (keyboardEvent.getKey() == KeyboardEvent.KEY_H) {
                if (player.getCurrentSide() == 0) {
                    if (player.getCurrentFrame() == 1) {
                        player.setCurrentFrame(2);
                        player.getPlayer().load("resources/PlayerSprites/bulbasaurSprites/left1.png");
                    } else if (player.getCurrentFrame() == 2) {
                        player.setCurrentFrame(1);
                        player.getPlayer().load("resources/PlayerSprites/bulbasaurSprites/left2.png");
                    }
                }

                if (player.getCurrentSide() == 1) {
                    if (player.getCurrentFrame() == 1) {
                        player.setCurrentFrame(2);
                        player.getPlayer().load("resources/PlayerSprites/bulbasaurSprites/up1.png");
                    } else if (player.getCurrentFrame() == 2) {
                        player.setCurrentFrame(1);
                        player.getPlayer().load("resources/PlayerSprites/bulbasaurSprites/up2.png");
                    }
                }

                if (player.getCurrentSide() == 2) {
                    if (player.getCurrentFrame() == 1) {
                        player.setCurrentFrame(2);
                        player.getPlayer().load("resources/PlayerSprites/bulbasaurSprites/right1.png");
                    } else if (player.getCurrentFrame() == 2) {
                        player.setCurrentFrame(1);
                        player.getPlayer().load("resources/PlayerSprites/bulbasaurSprites/right2.png");
                    }
                }

                if (player.getCurrentSide() == 3) {
                    if (player.getCurrentFrame() == 1) {
                        player.setCurrentFrame(2);
                        player.getPlayer().load("resources/PlayerSprites/bulbasaurSprites/down1.png");
                    } else if (player.getCurrentFrame() == 2) {
                        player.setCurrentFrame(1);
                        player.getPlayer().load("resources/PlayerSprites/bulbasaurSprites/down2.png");
                    }
                }
            }
            //endregion

            //region LEFT
            if (keyboardEvent.getKey() == KeyboardEvent.KEY_LEFT) {
                if (player.getCurrentFrame() == 1) {
                    player.setCurrentFrame(2);
                    player.setCurrentSide(0);
                    player.getPlayer().load("resources/PlayerSprites/bulbasaurSprites/left1.png");
                } else if (player.getCurrentFrame() == 2) {
                    player.setCurrentFrame(1);
                    player.setCurrentSide(0);
                    player.getPlayer().load("resources/PlayerSprites/bulbasaurSprites/left2.png");
                }
            }
            //endregion

            //region UP
            if (keyboardEvent.getKey() == KeyboardEvent.KEY_UP) {
                if (player.getCurrentFrame() == 1) {
                    player.setCurrentFrame(2);
                    player.setCurrentSide(1);
                    player.getPlayer().load("resources/PlayerSprites/bulbasaurSprites/up1.png");
                } else if (player.getCurrentFrame() == 2) {
                    player.setCurrentFrame(1);
                    player.setCurrentSide(1);
                    player.getPlayer().load("resources/PlayerSprites/bulbasaurSprites/up2.png");
                }
            }
            //endregion

            //region RIGHT
            if (keyboardEvent.getKey() == KeyboardEvent.KEY_RIGHT) {
                if (player.getCurrentFrame() == 1) {
                    player.setCurrentFrame(2);
                    player.setCurrentSide(2);
                    player.getPlayer().load("resources/PlayerSprites/bulbasaurSprites/right1.png");
                } else if (player.getCurrentFrame() == 2) {
                    player.setCurrentFrame(1);
                    player.setCurrentSide(2);
                    player.getPlayer().load("resources/PlayerSprites/bulbasaurSprites/right2.png");
                }
            }
            //endregion

            //region DOWN
            if (keyboardEvent.getKey() == KeyboardEvent.KEY_DOWN) {
                if (player.getCurrentFrame() == 1) {
                    player.setCurrentFrame(2);
                    player.setCurrentSide(3);
                    player.getPlayer().load("resources/PlayerSprites/bulbasaurSprites/down1.png");
                } else if (player.getCurrentFrame() == 2) {
                    player.setCurrentFrame(1);
                    player.setCurrentSide(3);
                    player.getPlayer().load("resources/PlayerSprites/bulbasaurSprites/down2.png");
                }
            }
            //endregion
        }
        //endregion

        //region SQUIRTLE
        if (player.getPokemon() == Pokemon.SQUIRTLE) {

            //region J
            if (keyboardEvent.getKey() == KeyboardEvent.KEY_J) {
                if (player.getCurrentSide() == 0) {
                    if (player.getCurrentFrame() == 1) {
                        player.setCurrentFrame(2);
                        player.getPlayer().load("resources/PlayerSprites/squirtleSprites/left1.png");
                    } else if (player.getCurrentFrame() == 2) {
                        player.setCurrentFrame(1);
                        player.getPlayer().load("resources/PlayerSprites/squirtleSprites/left2.png");
                    }
                }

                if (player.getCurrentSide() == 1) {
                    if (player.getCurrentFrame() == 1) {
                        player.setCurrentFrame(2);
                        player.getPlayer().load("resources/PlayerSprites/squirtleSprites/up1.png");
                    } else if (player.getCurrentFrame() == 2) {
                        player.setCurrentFrame(1);
                        player.getPlayer().load("resources/PlayerSprites/squirtleSprites/up2.png");
                    }
                }

                if (player.getCurrentSide() == 2) {
                    if (player.getCurrentFrame() == 1) {
                        player.setCurrentFrame(2);
                        player.getPlayer().load("resources/PlayerSprites/squirtleSprites/right1.png");
                    } else if (player.getCurrentFrame() == 2) {
                        player.setCurrentFrame(1);
                        player.getPlayer().load("resources/PlayerSprites/squirtleSprites/right2.png");
                    }
                }

                if (player.getCurrentSide() == 3) {
                    if (player.getCurrentFrame() == 1) {
                        player.setCurrentFrame(2);
                        player.getPlayer().load("resources/PlayerSprites/squirtleSprites/down1.png");
                    } else if (player.getCurrentFrame() == 2) {
                        player.setCurrentFrame(1);
                        player.getPlayer().load("resources/PlayerSprites/squirtleSprites/down2.png");
                    }
                }
            }
            //endregion

            //region LEFT
            if (keyboardEvent.getKey() == KeyboardEvent.KEY_LEFT) {
                if (player.getCurrentFrame() == 1) {
                    player.setCurrentFrame(2);
                    player.setCurrentSide(0);
                    player.getPlayer().load("resources/PlayerSprites/squirtleSprites/left1.png");
                } else if (player.getCurrentFrame() == 2) {
                    player.setCurrentFrame(1);
                    player.setCurrentSide(0);
                    player.getPlayer().load("resources/PlayerSprites/squirtleSprites/left2.png");
                }
            }
            //endregion

            //region UP
            if (keyboardEvent.getKey() == KeyboardEvent.KEY_UP) {
                if (player.getCurrentFrame() == 1) {
                    player.setCurrentFrame(2);
                    player.setCurrentSide(1);
                    player.getPlayer().load("resources/PlayerSprites/squirtleSprites/up1.png");
                } else if (player.getCurrentFrame() == 2) {
                    player.setCurrentFrame(1);
                    player.setCurrentSide(1);
                    player.getPlayer().load("resources/PlayerSprites/squirtleSprites/up2.png");
                }
            }
            //endregion

            //region RIGHT
            if (keyboardEvent.getKey() == KeyboardEvent.KEY_RIGHT) {
                if (player.getCurrentFrame() == 1) {
                    player.setCurrentFrame(2);
                    player.setCurrentSide(2);
                    player.getPlayer().load("resources/PlayerSprites/squirtleSprites/right1.png");
                } else if (player.getCurrentFrame() == 2) {
                    player.setCurrentFrame(1);
                    player.setCurrentSide(2);
                    player.getPlayer().load("resources/PlayerSprites/squirtleSprites/right2.png");
                }
            }
            //endregion

            //region DOWN
            if (keyboardEvent.getKey() == KeyboardEvent.KEY_DOWN) {
                if (player.getCurrentFrame() == 1) {
                    player.setCurrentFrame(2);
                    player.setCurrentSide(3);
                    player.getPlayer().load("resources/PlayerSprites/squirtleSprites/down1.png");
                } else if (player.getCurrentFrame() == 2) {
                    player.setCurrentFrame(1);
                    player.setCurrentSide(3);
                    player.getPlayer().load("resources/PlayerSprites/squirtleSprites/down2.png");
                }
            }
            //endregion
        }
        //endregion

        //region CHARMANDER
        if (player.getPokemon() == Pokemon.CHARMANDER) {

            //region K
            if (keyboardEvent.getKey() == KeyboardEvent.KEY_K) {
                if (player.getCurrentSide() == 0) {
                    if (player.getCurrentFrame() == 1) {
                        player.setCurrentFrame(2);
                        player.getPlayer().load("resources/PlayerSprites/charmanderSprites/left1.png");
                    } else if (player.getCurrentFrame() == 2) {
                        player.setCurrentFrame(1);
                        player.getPlayer().load("resources/PlayerSprites/charmanderSprites/left2.png");
                    }
                }

                if (player.getCurrentSide() == 1) {
                    if (player.getCurrentFrame() == 1) {
                        player.setCurrentFrame(2);
                        player.getPlayer().load("resources/PlayerSprites/charmanderSprites/up1.png");
                    } else if (player.getCurrentFrame() == 2) {
                        player.setCurrentFrame(1);
                        player.getPlayer().load("resources/PlayerSprites/charmanderSprites/up2.png");
                    }
                }

                if (player.getCurrentSide() == 2) {
                    if (player.getCurrentFrame() == 1) {
                        player.setCurrentFrame(2);
                        player.getPlayer().load("resources/PlayerSprites/charmanderSprites/right1.png");
                    } else if (player.getCurrentFrame() == 2) {
                        player.setCurrentFrame(1);
                        player.getPlayer().load("resources/PlayerSprites/charmanderSprites/right2.png");
                    }
                }

                if (player.getCurrentSide() == 3) {
                    if (player.getCurrentFrame() == 1) {
                        player.setCurrentFrame(2);
                        player.getPlayer().load("resources/PlayerSprites/charmanderSprites/down1.png");
                    } else if (player.getCurrentFrame() == 2) {
                        player.setCurrentFrame(1);
                        player.getPlayer().load("resources/PlayerSprites/charmanderSprites/down2.png");
                    }
                }
            }
            //endregion

            //region LEFT
            if (keyboardEvent.getKey() == KeyboardEvent.KEY_LEFT) {
                if (player.getCurrentFrame() == 1) {
                    player.setCurrentFrame(2);
                    player.setCurrentSide(0);
                    player.getPlayer().load("resources/PlayerSprites/charmanderSprites/left1.png");
                } else if (player.getCurrentFrame() == 2) {
                    player.setCurrentFrame(1);
                    player.setCurrentSide(0);
                    player.getPlayer().load("resources/PlayerSprites/charmanderSprites/left2.png");
                }
            }
            //endregion

            //region UP
            if (keyboardEvent.getKey() == KeyboardEvent.KEY_UP) {
                if (player.getCurrentFrame() == 1) {
                    player.setCurrentFrame(2);
                    player.setCurrentSide(1);
                    player.getPlayer().load("resources/PlayerSprites/charmanderSprites/up1.png");
                } else if (player.getCurrentFrame() == 2) {
                    player.setCurrentFrame(1);
                    player.setCurrentSide(1);
                    player.getPlayer().load("resources/PlayerSprites/charmanderSprites/up2.png");
                }
            }
            //endregion

            //region RIGHT
            if (keyboardEvent.getKey() == KeyboardEvent.KEY_RIGHT) {
                if (player.getCurrentFrame() == 1) {
                    player.setCurrentFrame(2);
                    player.setCurrentSide(2);
                    player.getPlayer().load("resources/PlayerSprites/charmanderSprites/right1.png");
                } else if (player.getCurrentFrame() == 2) {
                    player.setCurrentFrame(1);
                    player.setCurrentSide(2);
                    player.getPlayer().load("resources/PlayerSprites/charmanderSprites/right2.png");
                }
            }
            //endregion

            //region DOWN
            if (keyboardEvent.getKey() == KeyboardEvent.KEY_DOWN) {
                if (player.getCurrentFrame() == 1) {
                    player.setCurrentFrame(2);
                    player.setCurrentSide(3);
                    player.getPlayer().load("resources/PlayerSprites/charmanderSprites/down1.png");
                } else if (player.getCurrentFrame() == 2) {
                    player.setCurrentFrame(1);
                    player.setCurrentSide(3);
                    player.getPlayer().load("resources/PlayerSprites/charmanderSprites/down2.png");
                }
            }
            //endregion
        }
        //endregion

        //region PIKACHU
        if (player.getPokemon() == Pokemon.PIKACHU) {

            //region L
            if (keyboardEvent.getKey() == KeyboardEvent.KEY_L) {
                if (player.getCurrentSide() == 0) {
                    if (player.getCurrentFrame() == 1) {
                        player.setCurrentFrame(2);
                        player.getPlayer().load("resources/PlayerSprites/pikachuSprites/left1.png");
                    } else if (player.getCurrentFrame() == 2) {
                        player.setCurrentFrame(1);
                        player.getPlayer().load("resources/PlayerSprites/pikachuSprites/left2.png");
                    }
                }

                if (player.getCurrentSide() == 1) {
                    if (player.getCurrentFrame() == 1) {
                        player.setCurrentFrame(2);
                        player.getPlayer().load("resources/PlayerSprites/pikachuSprites/up1.png");
                    } else if (player.getCurrentFrame() == 2) {
                        player.setCurrentFrame(1);
                        player.getPlayer().load("resources/PlayerSprites/pikachuSprites/up2.png");
                    }
                }

                if (player.getCurrentSide() == 2) {
                    if (player.getCurrentFrame() == 1) {
                        player.setCurrentFrame(2);
                        player.getPlayer().load("resources/PlayerSprites/pikachuSprites/right1.png");
                    } else if (player.getCurrentFrame() == 2) {
                        player.setCurrentFrame(1);
                        player.getPlayer().load("resources/PlayerSprites/pikachuSprites/right2.png");
                    }
                }

                if (player.getCurrentSide() == 3) {
                    if (player.getCurrentFrame() == 1) {
                        player.setCurrentFrame(2);
                        player.getPlayer().load("resources/PlayerSprites/pikachuSprites/down1.png");
                    } else if (player.getCurrentFrame() == 2) {
                        player.setCurrentFrame(1);
                        player.getPlayer().load("resources/PlayerSprites/pikachuSprites/down2.png");
                    }
                }
            }
            //endregion

            //region LEFT
            if (keyboardEvent.getKey() == KeyboardEvent.KEY_LEFT) {
                if (player.getCurrentFrame() == 1) {
                    player.setCurrentFrame(2);
                    player.setCurrentSide(0);
                    player.getPlayer().load("resources/PlayerSprites/pikachuSprites/left1.png");
                } else if (player.getCurrentFrame() == 2) {
                    player.setCurrentFrame(1);
                    player.setCurrentSide(0);
                    player.getPlayer().load("resources/PlayerSprites/pikachuSprites/left2.png");
                }
            }
            //endregion

            //region UP
            if (keyboardEvent.getKey() == KeyboardEvent.KEY_UP) {
                if (player.getCurrentFrame() == 1) {
                    player.setCurrentFrame(2);
                    player.setCurrentSide(1);
                    player.getPlayer().load("resources/PlayerSprites/pikachuSprites/up1.png");
                } else if (player.getCurrentFrame() == 2) {
                    player.setCurrentFrame(1);
                    player.setCurrentSide(1);
                    player.getPlayer().load("resources/PlayerSprites/pikachuSprites/up2.png");
                }
            }
            //endregion

            //region RIGHT
            if (keyboardEvent.getKey() == KeyboardEvent.KEY_RIGHT) {
                if (player.getCurrentFrame() == 1) {
                    player.setCurrentFrame(2);
                    player.setCurrentSide(2);
                    player.getPlayer().load("resources/PlayerSprites/pikachuSprites/right1.png");
                } else if (player.getCurrentFrame() == 2) {
                    player.setCurrentFrame(1);
                    player.setCurrentSide(2);
                    player.getPlayer().load("resources/PlayerSprites/pikachuSprites/right2.png");
                }
            }
            //endregion

            //region DOWN
            if (keyboardEvent.getKey() == KeyboardEvent.KEY_DOWN) {
                if (player.getCurrentFrame() == 1) {
                    player.setCurrentFrame(2);
                    player.setCurrentSide(3);
                    player.getPlayer().load("resources/PlayerSprites/pikachuSprites/down1.png");
                } else if (player.getCurrentFrame() == 2) {
                    player.setCurrentFrame(1);
                    player.setCurrentSide(3);
                    player.getPlayer().load("resources/PlayerSprites/pikachuSprites/down2.png");
                }
            }
            //endregion
        }
        //endregion


    }

    }

