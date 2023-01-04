package mainJuego;

import personajes.*;

import java.util.Scanner;

import armas.*;

import java.util.Random;

public class Batalla {

	private Personaje ganador;
	
	public Batalla(Personaje per1, Arma arm1, Personaje per2, Arma arm2, int x) {
		Scanner entrada = new Scanner(System.in);
		int vida1=per1.getVida()*10;
		int ataque1=per1.getAtaque()*2;
		int defensa1=per1.getDefensa();
		int velocidad1=per1.getVelocidad();
		int defender1=0;
		
		int vida2=per2.getVida()*10;
		int ataque2=per2.getAtaque()*2;
		int defensa2=per2.getDefensa();
		int velocidad2=per2.getVelocidad();
		int defender2=0;
		
		int exit=0;
		int resistencia1=5;
		int resistencia2=5;
		int respuesta;
		int pasar=0;
		int morir=0;
		
		switch(per1.getRaza()) {
		case "Elemental":
			if(arm2.getArma()=="Martillo") {
				ataque2=ataque2*2;
			}
			break;
		case "Elfo":
			if(arm2.getArma()=="Arco") {
				ataque2=ataque2*2;
			}
			break;
		case "Enano":
			if(arm2.getArma()=="Daga") {
				ataque2=ataque2*2;
			}
			break;
		case "Humano":
			if(arm2.getArma()=="Lanza") {
				ataque2=ataque2*2;
			}
			break;
		case "Orco":
			if(arm2.getArma()=="Espada") {
				ataque2=ataque2*2;
			}
			break;
		}
		switch(per2.getRaza()) {
		case "Elemental":
			if(arm1.getArma()=="Martillo") {
				ataque1=ataque1*2;
			}
			break;
		case "Elfo":
			if(arm1.getArma()=="Arco") {
				ataque1=ataque1*2;
			}
			break;
		case "Enano":
			if(arm1.getArma()=="Daga") {
				ataque1=ataque1*2;
			}
			break;
		case "Humano":
			if(arm1.getArma()=="Lanza") {
				ataque1=ataque1*2;
			}
			break;
		case "Orco":
			if(arm1.getArma()=="Espada") {
				ataque1=ataque1*2;
			}
			break;
		}
		
		if(x==2) {
			while(exit!=1) {
				if(resistencia1==-2) resistencia1--;
				if(resistencia2==-2) resistencia2--;
				System.out.printf("Vida personaje 1:%d\n",vida1);
				System.out.printf("Vida personaje 2:%d\n",vida2);
				if(velocidad1>=velocidad2) {
					System.out.printf("Turno personaje 1\n");
					System.out.printf("resistencia:%d\n",resistencia1);
					System.out.printf("1:Atacar  2:Defender  3:Descansar\n");
					respuesta = entrada.nextInt();
					pasar=0;
					while(pasar==0) {
						switch(respuesta) {
						case 1:
							System.out.printf("El personaje 1 ataca\n");
							if (resistencia1<0) {
								if(defender2==1) {
									if(resistencia2<0) {
										vida2=vida2-((((ataque1*100-(ataque1*100/defensa2))/100)/(2/-resistencia2))/-resistencia1);
										resistencia1=resistencia1-2;
										defender2=0;
									}else {
										vida2=vida2-((((ataque1*100-(ataque1*100/defensa2))/100)/2)/-resistencia1);
										resistencia1=resistencia1-2;
										defender2=0;
									}
								}else {
									vida2=vida2-(((ataque1*100-(ataque1*100/defensa2))/100)/-resistencia1);
									resistencia1=resistencia1-2;
								}
							}else {
								if(defender2==1) {
									if(resistencia2<0) {
										vida2=vida2-(((ataque1*100-(ataque1*100/defensa2))/100)/(2/-resistencia2));
										resistencia1=resistencia1-2;
										defender2=0;
									}else {
										vida2=vida2-(((ataque1*100-(ataque1*100/defensa2))/100)/2);
										resistencia1=resistencia1-2;
										defender2=0;
									}
								}else {
									vida2=vida2-((ataque1*100-(ataque1*100/defensa2))/100);
									resistencia1=resistencia1-2;
								}
							}
							pasar=1;
							break;
						case 2:
							System.out.printf("El personaje 1 defiende\n");
							defender1=1;
							resistencia1--;
							pasar=1;
							break;
						case 3:
							System.out.printf("El personaje 1 descansa\n");
							resistencia1=5;
							pasar=1;
							break;
						default:
							System.out.printf("Error al introducir elección\n");
							break;
						
						}
					}
					System.out.printf("Vida personaje 1:%d\n",vida1);
					System.out.printf("Vida personaje 2:%d\n",vida2);
					if(vida2<0) {
						morir=1;
					}
					if(morir==0) {
						System.out.printf("Turno personaje 2\n");
						System.out.printf("resistencia:%d\n",resistencia2);
						System.out.printf("1:Atacar  2:Defender  3:Descansar\n");
						respuesta = entrada.nextInt();
						pasar=0;
						while(pasar==0) {
							switch(respuesta) {
							case 1:
								System.out.printf("El personaje 2 ataca\n");
								if (resistencia2<0) {
									if(defender1==1) {
										if(resistencia1<0) {
											vida1=vida1-((((ataque2*100-(ataque2*100/defensa1))/100)/(2/-resistencia1))/-resistencia2);
											resistencia2=resistencia2-2;
											defender1=0;
										}else {
											vida1=vida1-((((ataque2*100-(ataque2*100/defensa1))/100)/2)/-resistencia2);
											resistencia2=resistencia2-2;
											defender1=0;
										}
									}else {
										vida1=vida1-(((ataque2*100-(ataque2*100/defensa1))/100)/-resistencia2);
										resistencia2=resistencia2-2;
									}
								}else {
									if(defender1==1) {
										if(resistencia1<0) {
											vida1=vida1-(((ataque2*100-(ataque2*100/defensa1))/100)/(2/-resistencia1));
											resistencia2=resistencia2-2;
											defender1=0;
										}else {
											vida1=vida1-(((ataque2*100-(ataque2*100/defensa1))/100)/2);
											resistencia2=resistencia2-2;
											defender1=0;
										}
									}else {
										vida1=vida1-((ataque2*100-(ataque2*100/defensa1))/100);
										resistencia2=resistencia2-2;
									}
								}
								pasar=1;
								break;
							case 2:
								System.out.printf("El personaje 2 defiende\n");
								defender2=1;
								resistencia2--;
								pasar=1;
								break;
							case 3:
								System.out.printf("El personaje 2 descansa\n");
								resistencia2=5;
								pasar=1;
								break;
							default:
								System.out.printf("Error al introducir elección\n");
								break;
							
							}
						}
					}
				}else {
					System.out.printf("Turno personaje 2\n");
					System.out.printf("resistencia:%d\n",resistencia2);
					System.out.printf("1:Atacar  2:Defender  3:Descansar\n");
					respuesta = entrada.nextInt();
					pasar=0;
					while(pasar==0) {
						switch(respuesta) {
						case 1:
							System.out.printf("El personaje 2 ataca\n");
							if (resistencia2<0) {
								if(defender1==1) {
									if(resistencia1<0) {
										vida1=vida1-((((ataque2*100-(ataque2*100/defensa1))/100)/(2/-resistencia1))/-resistencia2);
										resistencia2=resistencia2-2;
										defender1=0;
									}else {
										vida1=vida1-((((ataque2*100-(ataque2*100/defensa1))/100)/2)/-resistencia2);
										resistencia2=resistencia2-2;
										defender1=0;
									}
								}else {
									vida1=vida1-(((ataque2*100-(ataque2*100/defensa1))/100)/-resistencia2);
									resistencia2=resistencia2-2;
								}
							}else {
								if(defender1==1) {
									if(resistencia1<0) {
										vida1=vida1-(((ataque2*100-(ataque2*100/defensa1))/100)/(2/-resistencia1));
										resistencia2=resistencia2-2;
										defender1=0;
									}else {
										vida1=vida1-(((ataque2*100-(ataque2*100/defensa1))/100)/2);
										resistencia2=resistencia2-2;
										defender1=0;
									}
								}else {
									vida1=vida1-((ataque2*100-(ataque2*100/defensa1))/100);
									resistencia2=resistencia2-2;
								}
							}
							pasar=1;
							break;
						case 2:
							System.out.printf("El personaje 2 defiende\n");
							defender2=1;
							resistencia2--;
							pasar=1;
							break;
						case 3:
							System.out.printf("El personaje 2 descansa\n");
							resistencia2=5;
							pasar=1;
							break;
						default:
							System.out.printf("Error al introducir elección\n");
							break;
						}
					}
					System.out.printf("Vida personaje 1:%d\n",vida1);
					System.out.printf("Vida personaje 2:%d\n",vida2);
					if(vida1<0) {
						morir=1;
					}
					if(morir!=1) {
						System.out.printf("Turno personaje 1\n");
						System.out.printf("resistencia:%d\n",resistencia1);
						System.out.printf("1:Atacar  2:Defender  3:Descansar\n");
						respuesta = entrada.nextInt();
						pasar=0;
						while(pasar==0) {
							switch(respuesta) {
							case 1:
								System.out.printf("El personaje 1 ataca\n");
								if (resistencia1<0) {
									if(defender2==1) {
										if(resistencia2<0) {
											vida2=vida2-((((ataque1*100-(ataque1*100/defensa2))/100)/(2/-resistencia2))/-resistencia1);
											resistencia1=resistencia1-2;
											defender2=0;
										}else {
											vida2=vida2-((((ataque1*100-(ataque1*100/defensa2))/100)/2)/-resistencia1);
											resistencia1=resistencia1-2;
											defender2=0;
										}
									}else {
										vida2=vida2-(((ataque1*100-(ataque1*100/defensa2))/100)/-resistencia1);
										resistencia1=resistencia1-2;
									}
								}else {
									if(defender2==1) {
										if(resistencia2<0) {
											vida2=vida2-(((ataque1*100-(ataque1*100/defensa2))/100)/(2/-resistencia2));
											resistencia1=resistencia1-2;
											defender2=0;
										}else {
											vida2=vida2-(((ataque1*100-(ataque1*100/defensa2))/100)/2);
											resistencia1=resistencia1-2;
											defender2=0;
										}
									}else {
										vida2=vida2-((ataque1*100-(ataque1*100/defensa2))/100);
										resistencia1=resistencia1-2;
									}
								}
								pasar=1;
								break;
							case 2:
								System.out.printf("El personaje 1 defiende\n");
								defender1=1;
								resistencia1--;
								pasar=1;
								break;
							case 3:
								System.out.printf("El personaje descansa\n");
								resistencia1=5;
								pasar=1;
								break;
							default:
								System.out.printf("Error al introducir elección\n");
								break;
							
							}
						}
					}
				}
				if(vida1<0) {
					System.out.printf("Gana personaje 2\n");
					ganador = per2;
					exit=1;
				}
				if(vida2<0) {
					System.out.printf("Gana personaje 1\n");	
					ganador = per1;
					exit=1;
				}
			}
		}
		if(x==1) {
			while(exit!=1) {
				if(resistencia1==-2) resistencia1--;
				if(resistencia2==-2) resistencia2--;
				System.out.printf("Vida personaje 1:%d\n",vida1);
				System.out.printf("Vida personaje 2:%d\n",vida2);
				if(velocidad1>=velocidad2) {
					System.out.printf("Turno personaje 1\n");
					System.out.printf("resistencia:%d\n",resistencia1);
					System.out.printf("1:Atacar  2:Defender  3:Descansar\n");
					respuesta = entrada.nextInt();
					pasar=0;
					while(pasar==0) {
						switch(respuesta) {
						case 1:
							System.out.printf("El personaje 1 ataca\n");
							if (resistencia1<0) {
								if(defender2==1) {
									if(resistencia2<0) {
										vida2=vida2-((((ataque1*100-(ataque1*100/defensa2))/100)/(2/-resistencia2))/-resistencia1);
										resistencia1=resistencia1-2;
										defender2=0;
									}else {
										vida2=vida2-((((ataque1*100-(ataque1*100/defensa2))/100)/2)/-resistencia1);
										resistencia1=resistencia1-2;
										defender2=0;
									}
								}else {
									vida2=vida2-(((ataque1*100-(ataque1*100/defensa2))/100)/-resistencia1);
									resistencia1=resistencia1-2;
								}
							}else {
								if(defender2==1) {
									if(resistencia2<0) {
										vida2=vida2-(((ataque1*100-(ataque1*100/defensa2))/100)/(2/-resistencia2));
										resistencia1=resistencia1-2;
										defender2=0;
									}else {
										vida2=vida2-(((ataque1*100-(ataque1*100/defensa2))/100)/2);
										resistencia1=resistencia1-2;
										defender2=0;
									}
								}else {
									vida2=vida2-((ataque1*100-(ataque1*100/defensa2))/100);
									resistencia1=resistencia1-2;
								}
							}
							pasar=1;
							break;
						case 2:
							System.out.printf("El personaje 1 defiende\n");
							defender1=1;
							resistencia1--;
							pasar=1;
							break;
						case 3:
							System.out.printf("El personaje 1 descansa\n");
							resistencia1=5;
							pasar=1;
							break;
						default:
							System.out.printf("Error al introducir elección\n");
							break;
						
						}
					}
					System.out.printf("Vida personaje 1:%d\n",vida1);
					System.out.printf("Vida personaje 2:%d\n",vida2);
					if(vida2<0) {
						morir=1;
					}
					if(morir==0) {
						System.out.printf("Turno personaje 2\n");
						System.out.printf("resistencia:%d\n",resistencia2);
						respuesta = getRandom(1, 3);
						pasar=0;
						while(pasar==0) {
							switch(respuesta) {
							case 1:
								System.out.printf("El personaje 2 ataca\n");
								if (resistencia2<0) {
									if(defender1==1) {
										if(resistencia1<0) {
											vida1=vida1-((((ataque2*100-(ataque2*100/defensa1))/100)/(2/-resistencia1))/-resistencia2);
											resistencia2=resistencia2-2;
											defender1=0;
										}else {
											vida1=vida1-((((ataque2*100-(ataque2*100/defensa1))/100)/2)/-resistencia2);
											resistencia2=resistencia2-2;
											defender1=0;
										}
									}else {
										vida1=vida1-(((ataque2*100-(ataque2*100/defensa1))/100)/-resistencia2);
										resistencia2=resistencia2-2;
									}
								}else {
									if(defender1==1) {
										if(resistencia1<0) {
											vida1=vida1-(((ataque2*100-(ataque2*100/defensa1))/100)/(2/-resistencia1));
											resistencia2=resistencia2-2;
											defender1=0;
										}else {
											vida1=vida1-(((ataque2*100-(ataque2*100/defensa1))/100)/2);
											resistencia2=resistencia2-2;
											defender1=0;
										}
									}else {
										vida1=vida1-((ataque2*100-(ataque2*100/defensa1))/100);
										resistencia2=resistencia2-2;
									}
								}
								pasar=1;
								break;
							case 2:
								System.out.printf("El personaje 2 defiende\n");
								defender2=1;
								resistencia2--;
								pasar=1;
								break;
							case 3:
								System.out.printf("El personaje 2 descansa\n");
								resistencia2=5;
								pasar=1;
								break;
							default:
								System.out.printf("Error al introducir elección\n");
								break;
							
							}
						}
					}
				}else {
					System.out.printf("Turno personaje 2\n");
					System.out.printf("resistencia:%d\n",resistencia2);
					respuesta = getRandom(1, 3);
					pasar=0;
					while(pasar==0) {
						switch(respuesta) {
						case 1:
							System.out.printf("El personaje 2 ataca\n");
							if (resistencia2<0) {
								if(defender1==1) {
									if(resistencia1<0) {
										vida1=vida1-((((ataque2*100-(ataque2*100/defensa1))/100)/(2/-resistencia1))/-resistencia2);
										resistencia2=resistencia2-2;
										defender1=0;
									}else {
										vida1=vida1-((((ataque2*100-(ataque2*100/defensa1))/100)/2)/-resistencia2);
										resistencia2=resistencia2-2;
										defender1=0;
									}
								}else {
									vida1=vida1-(((ataque2*100-(ataque2*100/defensa1))/100)/-resistencia2);
									resistencia2=resistencia2-2;
								}
							}else {
								if(defender1==1) {
									if(resistencia1<0) {
										vida1=vida1-(((ataque2*100-(ataque2*100/defensa1))/100)/(2/-resistencia1));
										resistencia2=resistencia2-2;
										defender1=0;
									}else {
										vida1=vida1-(((ataque2*100-(ataque2*100/defensa1))/100)/2);
										resistencia2=resistencia2-2;
										defender1=0;
									}
								}else {
									vida1=vida1-((ataque2*100-(ataque2*100/defensa1))/100);
									resistencia2=resistencia2-2;
								}
							}
							pasar=1;
							break;
						case 2:
							System.out.printf("El personaje 2 defiende\n");
							defender2=1;
							resistencia2--;
							pasar=1;
							break;
						case 3:
							System.out.printf("El personaje 2 descansa\n");
							resistencia2=5;
							pasar=1;
							break;
						default:
							System.out.printf("Error al introducir elección\n");
							break;
						}
					}
					System.out.printf("Vida personaje 1:%d\n",vida1);
					System.out.printf("Vida personaje 2:%d\n",vida2);
					if(vida1<0) {
						morir=1;
					}
					if(morir==1) {
						System.out.printf("Turno personaje 1\n");
						System.out.printf("resistencia:%d\n",resistencia1);
						System.out.printf("1:Atacar  2:Defender  3:Descansar\n");
						respuesta = entrada.nextInt();
						pasar=0;
						while(pasar==0) {
							switch(respuesta) {
							case 1:
								System.out.printf("El personaje 1 ataca\n");
								if (resistencia1<0) {
									if(defender2==1) {
										if(resistencia2<0) {
											vida2=vida2-((((ataque1*100-(ataque1*100/defensa2))/100)/(2/-resistencia2))/-resistencia1);
											resistencia1=resistencia1-2;
											defender2=0;
										}else {
											vida2=vida2-((((ataque1*100-(ataque1*100/defensa2))/100)/2)/-resistencia1);
											resistencia1=resistencia1-2;
											defender2=0;
										}
									}else {
										vida2=vida2-(((ataque1*100-(ataque1*100/defensa2))/100)/-resistencia1);
										resistencia1=resistencia1-2;
									}
								}else {
									if(defender2==1) {
										if(resistencia2<0) {
											vida2=vida2-(((ataque1*100-(ataque1*100/defensa2))/100)/(2/-resistencia2));
											resistencia1=resistencia1-2;
											defender2=0;
										}else {
											vida2=vida2-(((ataque1*100-(ataque1*100/defensa2))/100)/2);
											resistencia1=resistencia1-2;
											defender2=0;
										}
									}else {
										vida2=vida2-((ataque1*100-(ataque1*100/defensa2))/100);
										resistencia1=resistencia1-2;
									}
								}
								pasar=1;
								break;
							case 2:
								System.out.printf("El personaje 1 defiende\n");
								defender1=1;
								resistencia1--;
								pasar=1;
								break;
							case 3:
								System.out.printf("El personaje descansa\n");
								resistencia1=5;
								pasar=1;
								break;
							default:
								System.out.printf("Error al introducir elección\n");
								break;
							
							}
						}
					}
				}
				if(vida1<0) {
					System.out.printf("Gana personaje 2\n");
					ganador = per2;
					exit=1;
				}
				if(vida2<0) {
					System.out.printf("Gana personaje 1\n");	
					ganador = per1;
					exit=1;
				}
			}	
		}
		
	}
	
	private int getRandom(int min, int max) {
		Random random = new Random();
		return random.nextInt((max - min) + 1) + min;
	}
	
	public Personaje getGanador() {
		return ganador;
	}
}
