package dao;

public class daoSondage {

    /*private void createSondage() {
        //int numOfSondages = manager.createQuery("Select s From Sondage s", Sondage.class).getResultList().size();
        //if (numOfSondages == 0) {
        Participant saly = new Participant("Knab", "Saly", "sk@ad.fr");
        Participant maud = new Participant("Garcon", "Maud", "mg@ad.fr");
        Reunion reunion = new Reunion("miage", "reu entre maud et saly");
        manager.persist(saly);
        manager.persist(maud);
        manager.persist(reunion);
        Sondage sondage = new Sondage(reunion);
        Date date = new Date("09/01",true);
        Date date1 = new Date("10/01",false);
        manager.persist(date);
        manager.persist(date1);
        reunion.setSondage(sondage);
        saly.addSondagesCrees(sondage);
        sondage.addParticipant(saly);
        saly.addSondagesParticipes(sondage);
        sondage.addParticipant(maud);
        maud.addSondagesParticipes(sondage);
        sondage.addDate(date);
        sondage.addDate(date1);
        sondage.addReponse(date, saly);
        sondage.addReponse(date1, maud);
        //sondage.addReponse(date1, saly);

        manager.persist(sondage);
        //}
    }

    private void listSondages() {
        List<Sondage> resultList = manager.createQuery("Select a From Sondage a", Sondage.class).getResultList();
        System.out.println("num of Sondage:" + resultList.size());
        for (Sondage next : resultList) {
            System.out.println("next Sondage: " + next);
        }
    }
    
     */
}
