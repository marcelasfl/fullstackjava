package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.RedeMtDTO;
import com.example.demo.model.RedeMt;
import com.example.demo.repository.RedeMtRepository;
import com.example.demo.repository.SubestacaoRepository;

@Service
public class RedeMtService {

  @Autowired
  private RedeMtRepository redeMtRepository;

  @Autowired
  private SubestacaoRepository subestacaoRepository;

  
  @Autowired
  private ModelMapper modelMapper; // Injeção do ModelMapper

  // Criar uma nova rede MT
  public RedeMt createRedeMt(RedeMtDTO data) {
    RedeMt redeMt = new RedeMt();

    redeMt.setIdRedeMt(data.getIdRedeMt());
    redeMt.setCodigo(data.getCodigo());
    redeMt.setNome(data.getNome());
    redeMt.setTensaoNominal(data.getTensaoNominal());
    redeMt.setSubestacao(subestacaoRepository.findById(data.getIdSubestacao()).orElse(null));
    

    return redeMtRepository.save(redeMt);
  }

  public List<RedeMt> getAllRedesMt() {
    return redeMtRepository.findAll();
  }

  // Obter uma rede MT por ID
  public Optional<RedeMtDTO> getRedeMtById(Long id) {
    Optional<RedeMt> redeMtOptional = redeMtRepository.findById(id);

    if (redeMtOptional.isPresent()) {
      RedeMt redeMt = redeMtOptional.get();
      RedeMtDTO redeMtDTO = modelMapper.map(redeMt, RedeMtDTO.class);
      return Optional.of(redeMtDTO);
    } else {
      return Optional.empty(); // Retorna Optional.empty caso não encontre
    }
  }

  // Atualizar uma rede MT
  public Optional<RedeMt> updateRedeMt(Long id, RedeMt redeMtDetails) {
    return redeMtRepository.findById(id)
        .map(redeMt -> {
          redeMt.setCodigo(redeMtDetails.getCodigo());
          redeMt.setNome(redeMtDetails.getNome());
          redeMt.setTensaoNominal(redeMtDetails.getTensaoNominal());
          redeMt.setSubestacao(redeMtDetails.getSubestacao());
          return redeMtRepository.save(redeMt);
        });
  }

  // Deletar uma rede MT
  public boolean deleteRedeMt(Long id) {
    return redeMtRepository.findById(id)
        .map(redeMt -> {
          redeMtRepository.delete(redeMt);
          return true;
        }).orElse(false);
  }
}
