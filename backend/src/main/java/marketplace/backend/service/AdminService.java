package marketplace.backend.service;

import marketplace.backend.model.Admin;

public interface AdminService {
    
    public Admin findById(Long id);

    public Admin add(Admin admin);

    public Admin update(Admin admin);

    public void deleteById(Long id);
}
