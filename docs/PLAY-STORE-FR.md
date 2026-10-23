# Publier Android2USB sur Google Play

## 1. Créer le compte
Ouvrir https://play.google.com/console/signup .
Choisir un compte personnel ou organisation selon le statut réel du développeur.
Le coût annoncé est de 25 USD, payé une seule fois. Terminer la vérification d’identité.
Un nouveau compte personnel peut aussi demander une vérification avec un appareil Android.

## 2. Tester l’application
Installer Android2USB-test.apk depuis le dernier résultat GitHub Actions.
Tester les langues, le redémarrage de l’appareil, les dossiers enregistrés, les sous-dossiers, les doublons,
un gros fichier, le manque d’espace, le retrait de la clé et la reprise. Vérifier des fichiers copiés.
Tester sur Android 17 avant de déclarer sa compatibilité.
Le test APK utilise une clé de débogage différente de la première version Copie USB.
Il faut donc signer avec la clé initiale ou désinstaller l’ancienne application.
La désinstallation efface les paramètres, mais pas les photos ni les copies USB.

## 3. Préparer le bundle signé
Google Play attend un Android App Bundle (.aab), pas le test APK.
Le résultat CI Android2USB-unsigned.aab n’est pas encore signé pour Google Play.

Option simple dans Android Studio :
1. Télécharger Android2USB-source.zip depuis les résultats GitHub Actions.
2. Extraire et ouvrir le projet dans Android Studio. Attendre la synchronisation Gradle.
3. Choisir Build > Generate Signed App Bundle or APK > Android App Bundle.
4. Créer une clé d’importation privée. Stocker le fichier de clé et ses mots de passe hors du dépôt.
5. Choisir la variante release et produire le bundle signé.
6. Garder une copie sûre de la clé pour les versions suivantes.

L’identifiant actuel est ch.xs3.android2usb. Le nom affiché est Android2USB.
Décider avant la première publication si cet identifiant doit changer : il est permanent dans Google Play.
Augmenter versionCode à chaque mise à jour. La version actuelle utilise 6.
Le projet compile avec SDK 36 et cible API 37. Installer les SDK demandés par Android Studio.
Vérifier les exigences de niveau cible indiquées dans Play Console au moment du dépôt.

## 4. Créer la fiche
Dans Play Console, créer Android2USB comme application gratuite, catégorie Outils.
Ajouter les descriptions en français et anglais, une adresse de support et le site XS3.
Utiliser icon-512.png pour l’icône et feature-graphic-1024x500.png pour la bannière.
Ajouter au moins deux captures réelles sur téléphone. Ne pas présenter une maquette comme une capture.
Textes proposés dans STORE-LISTING.md.

## 5. Publier la politique de confidentialité
Le fichier docs/privacy.html contient une page FR/EN.
Vérifier le contact info@xs3.ch avant de la publier.
On peut la copier sur le site XS3. Autre possibilité : GitHub Settings > Pages > Deploy from a branch > main > /docs.
Après activation et vérification, l’adresse attendue est https://mfarad.github.io/Android2USB/privacy.html .
Cette page n’est pas automatiquement publiée par la création du fichier.

## 6. Remplir les déclarations
- Publicité : aucune publicité intégrée.
- Accès à l’application : aucun compte nécessaire.
- Sécurité des données : le code actuel ne transmet pas les fichiers, ne contient pas de suivi et n’a pas la permission Internet. Vérifier les réponses selon les définitions du formulaire.
- Liens externes : Buy Me a Coffee, GitHub et XS3 ouvrent un navigateur ou une autre application.
- Public cible et classification du contenu : répondre selon le public visé.
- Service au premier plan : déclarer dataSync. Expliquer que l’utilisateur lance une copie locale vers USB, voit la progression et peut l’arrêter. Fournir la vidéo demandée par la console.
- Aucune permission d’accès global aux fichiers ni READ_MEDIA_IMAGES n’est utilisée : les dossiers sont autorisés par le sélecteur Android.

## 7. Vérifier le soutien Buy Me a Coffee
Le bouton est facultatif et ne débloque aucun contenu, service, badge ou fonction.
Google indique que les contributions allant à 100 % au créateur, sans avantage numérique, peuvent être traitées comme des paiements entre personnes et ne pas utiliser Play Billing.
Vérifier que le fonctionnement réel du compte Buy Me a Coffee respecte ces conditions avant publication. Ne pas utiliser ce bouton pour vendre une fonction.
L’acceptation finale dépend de l’examen Google Play.

## 8. Tester via Google Play
Activer Play App Signing lors de la première version.
Téléverser le bundle signé sur le canal de test interne.
Pour les comptes personnels créés après le 13 novembre 2023, Google demande un test fermé avec au moins
12 testeurs inscrits pendant 14 jours consécutifs avant la demande d’accès à la production.
Ces conditions ne garantissent pas à elles seules l’approbation : il faut fournir les retours et résultats de test.

## 9. Demander la publication
Corriger les erreurs des rapports de pré-lancement, compléter les formulaires et demander l’accès à la production si nécessaire.
Créer la version de production, choisir les pays, ajouter les notes de version et envoyer pour examen.
L’application n’est pas publiée par ce dépôt GitHub.

## Sources officielles consultées le 20 octobre 2026
- Compte et frais : https://support.google.com/googleplay/android-developer/answer/6112435
- Tests personnels : https://support.google.com/googleplay/android-developer/answer/14151465
- Fiche, bundle et signature : https://support.google.com/googleplay/android-developer/answer/9859152
- Sécurité des données : https://support.google.com/googleplay/android-developer/answer/10787469
- Service au premier plan : https://support.google.com/googleplay/android-developer/answer/13392821
- Contributions : https://support.google.com/googleplay/android-developer/answer/10281818
