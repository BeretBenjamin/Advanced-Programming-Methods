package repository;

import model.PrgState;

import java.util.List;

public interface IRepository {
    public List<PrgState> getPrgList();

    PrgState getCrtPrg();

    void addPrg(PrgState prg);
}
