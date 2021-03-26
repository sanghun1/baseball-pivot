package com.cos.baseball.domain.team;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.CreationTimestamp;

import com.cos.baseball.domain.stadium.Stadium;
import com.cos.baseball.domain.player.Player;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Team {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	
	@OneToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "stadiumId" )
	@JsonIgnoreProperties({"team"})
	private Stadium stadium;
	
	@JsonIgnoreProperties({"team"})
	@OneToMany(mappedBy = "team", cascade = CascadeType.REMOVE)
	private List<Player> players;
	
	@CreationTimestamp
	private Timestamp createDate;
}