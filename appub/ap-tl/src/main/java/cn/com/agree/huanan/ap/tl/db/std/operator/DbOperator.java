package cn.com.agree.huanan.ap.tl.db.std.operator;

public interface DbOperator {
    public Selecter getSelecter();
    public Inserter getInserter();
    public Updater getUpdater();
    public Deleter getDeleter();
    public void commit();
    public void rollback();
    
    public Procedurer getProcedurer();
}
