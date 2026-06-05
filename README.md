# One Visit Backend

Tämä backend-palvelu mahdollistaa sivun, jossa käyttäjä voi vierailla vain yhden kerran. Käynti tunnistetaan IP-osoitteen perusteella. Jos käyttäjä yrittää palata uudelleen, hänet ohjataan estosivulle.

## Frontend -> https://github.com/ilarikoik/visitoncefrontend

## Toimintaperiaate

- Ensimmäisellä vierailulla käyttäjän IP-osoite tallennetaan tietokantaan tai muistiin.
- Jos sama IP-osoite yrittää vierailla uudelleen:
  - Käyttäjä ohjataan "access denied" -sivulle
- Muuten käyttäjä pääsee normaalille sivulle.

## Huomioitavaa

- IP-perusteinen tunnistus ei ole täysin varma (esim. VPN, mobiiliverkot ja NAT voivat vaikuttaa).
- Tämä ei ole vahva käyttäjätunnistusjärjestelmä, vaan kevyt rajoitusmekanismi.

## Teknologiat

Esimerkki toteutus voi käyttää:

- Java 
- Springboot

Tietokanta:
- PostgreSQL

## API-käyttäytyminen

### GET /

- Tarkistaa käyttäjän IP-osoitteen
- Jos IP ei ole rekisterissä:
  - Tallennetaan IP
  - Palautetaan pääsisältö
- Jos IP löytyy:
  - Redirect 


