
(ns datashow-management.core)

;; Lista inicial de datashows com suas alocações
(def datashows
  [ {:id 1 :reservas []}
    {:id 2 :reservas []}
    {:id 3 :reservas []} ])

;; Função para verificar disponibilidade de um datashow
(defn disponivel? [datashow dia hora-inicio hora-fim]
  (not-any? #(and (= (:dia %) dia)
                  (< hora-inicio (:hora-fim %))
                  (> hora-fim (:hora-inicio %)))
            (:reservas datashow)))


(defn verificar-disponibilidade [datashows id dia hora-inicio hora-fim]
  (if (empty? datashows)
    (println "Datashow com ID" id "não encontrado.")
    (let [datashow (first datashows)]
      (if (= (:id datashow) id)
        (if (disponivel? datashow dia hora-inicio hora-fim)
          (println "O datashow com ID" id "está disponível.")
          (println "O datashow com ID" id "não está disponível no horário solicitado."))
        (recur (rest datashows) id dia hora-inicio hora-fim)))))


(defn alocar-datashow [datashows id dia hora-inicio hora-fim]
  (mapv (fn [datashow]
          (if (= (:id datashow) id)
            (if (disponivel? datashow dia hora-inicio hora-fim)
              (do
                (println "Datashow com ID" id "alocado com sucesso.")
                (update datashow :reservas conj {:dia dia :hora-inicio hora-inicio :hora-fim hora-fim}))
              (do
                (println "Datashow com ID" id "não pode ser alocado. Já está ocupado no horário solicitado.")
                datashow))
            datashow))
        datashows)))


(defn desalocar-datashow [datashows id dia hora-inicio hora-fim]
  (mapv (fn [datashow]
          (if (= (:id datashow) id)
            (do
              (println "Removendo reserva do datashow com ID" id ".")
              (update datashow :reservas (fn [reservas]
                                           (remove #(and (= (:dia %) dia)
                                                         (= (:hora-inicio %) hora-inicio)
                                                         (= (:hora-fim %) hora-fim))
                                                   reservas))))
            datashow))
        datashows))
;;Adicione os DATASHOWS aqui



;;Verifique a disponibilidade dos DATASHOWS aqui
