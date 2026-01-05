<img width="1860" height="270" alt="image" src="https://github.com/user-attachments/assets/b152c5d3-cfee-4050-86e6-71a8a27614f1" />
<img width="1797" height="295" alt="image" src="https://github.com/user-attachments/assets/5acd2217-7a67-41ad-8e65-ad177be17f31" />
<img width="1702" height="261" alt="image" src="https://github.com/user-attachments/assets/4b119ea3-2910-4931-b01f-163995149fb0" />
<img width="1521" height="332" alt="image" src="https://github.com/user-attachments/assets/edd7e8da-3221-4c5d-bd91-76fe0f78e170" />
<img width="1788" height="466" alt="image" src="https://github.com/user-attachments/assets/6355fab0-ffa1-414c-8f94-8084bca6adb7" />
<img width="1813" height="609" alt="image" src="https://github.com/user-attachments/assets/bef9a458-6f18-449f-9aca-cde3f2c0e49d" />
<img width="1801" height="605" alt="image" src="https://github.com/user-attachments/assets/23638818-c602-409e-8a10-b5fc559fd1f5" />
<img width="1744" height="348" alt="image" src="https://github.com/user-attachments/assets/23a17339-3dc1-4051-a18e-ba98b9958a5c" />
<img width="1791" height="499" alt="image" src="https://github.com/user-attachments/assets/ab468ea8-974d-4a60-a069-3e1c50306827" />
<img width="1480" height="416" alt="image" src="https://github.com/user-attachments/assets/ceb714db-504e-448d-8306-69aa931f8619" />
CONCLUSION

1. Verrou DB en multi-instances :
Sans le verrou pessimiste (PESSIMISTIC_WRITE), plusieurs instances peuvent lire simultanément le même stock (ex: stock=1), décrémenter chacune localement, puis écrire leurs modifications en parallèle, causant un stock négatif ou des doubles emprunts. Le verrou MySQL force la sérialisation des transactions : une seule instance à la fois peut lire, modifier et sauvegarder le stock, garantissant l'intégrité des données et évitant les conditions de concurrence (race conditions).
2. Circuit Breaker et Fallback :
Le circuit breaker surveille le taux d'échec des appels au service pricing (seuil: 50% sur 10 appels). Lorsque ce seuil est dépassé, il "ouvre" le circuit et bloque temporairement les nouveaux appels pendant 10 secondes, évitant de surcharger un service déjà défaillant. Le fallback complète cette protection en retournant une valeur par défaut (price=0.0) au lieu de propager l'erreur, permettant au service book-service de continuer à fonctionner en mode dégradé, assurant ainsi la disponibilité et la résilience globale du système distribué.
